package com.example.testtaskquestions.gameScreen

import com.example.testtaskquestions.BookModel
import com.example.testtaskquestions.QuestionFactory
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class GamePresenter
@Inject constructor(
    private val questionFactory: QuestionFactory
) : MvpPresenter<GameView>() {

    private val questions = questionFactory.getQuestionList()
    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    private var wrongAnswers = 0

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
        if (selectedBook == currentQuestion.correctBook) {
            correctAnswers++
        } else {
            wrongAnswers++
        }
    }

    private fun nextQuestionOrFinalScreen() {
        if (currentQuestionIndex < questions.lastIndex) {
            currentQuestionIndex++
            showQuestion()
        } else {
            viewState.openFinalScreen(correctAnswers, wrongAnswers)
        }
    }

    private fun showQuestion() {
        viewState.showQuestion(questions[currentQuestionIndex])
    }
}