package com.example.testtaskquestions.presentation.gameScreen

import com.example.testtaskquestions.data.model.QuestionModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GameView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showQuestion(question: QuestionModel)

    @StateStrategyType(SkipStrategy::class)
    fun openFinalScreen(correctAnswers: Int, wrongAnswers: Int)
}