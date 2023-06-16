package com.example.testtaskquestions.presentation.gameScreen

import com.example.testtaskquestions.data.factory.QuestionFactory
import com.example.testtaskquestions.data.model.BookModel
import com.example.testtaskquestions.data.repository.AnswersRepository
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class GamePresenter
@Inject constructor(
    private val questionFactory: QuestionFactory,
    private val answersRepository: AnswersRepository,
) : MvpPresenter<GameView>() {

    private val questions = questionFactory.getQuestionList()
    private var currentQuestionIndex = 0


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        showQuestion()
    }

    fun onBookPressed(bookIndex: Int) {
        val pressedBook = questions[currentQuestionIndex].books[bookIndex]
        calculateScore(pressedBook)
        nextQuestionOrFinalScreen()
    }

    private fun calculateScore(selectedBook: BookModel) {
        val currentQuestion = questions[currentQuestionIndex]
        answersRepository.addAnswer(selectedBook, currentQuestion)
    }

    private fun nextQuestionOrFinalScreen() {
        if (currentQuestionIndex < questions.lastIndex) {
            currentQuestionIndex++
            showQuestion()
        } else {
            viewState.openFinalScreen(
                answersRepository.getCorrectAnswersCount(),
                answersRepository.getWrongAnswersCount(),
            )
        }
    }

    private fun showQuestion() {
        viewState.showQuestion(questions[currentQuestionIndex])
    }
}