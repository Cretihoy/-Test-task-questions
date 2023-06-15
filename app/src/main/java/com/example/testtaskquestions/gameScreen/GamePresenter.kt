package com.example.testtaskquestions.gameScreen

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
    var currentQuestionIndex = 0

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        showQuestion()
    }

    fun onBookPressed() {
        if (currentQuestionIndex < questions.lastIndex) {
            currentQuestionIndex++
            showQuestion()
        } else {
            viewState.showFinalScreen()
        }
    }

    private fun showQuestion() {
        viewState.showQuestion(questions[currentQuestionIndex])
    }
}