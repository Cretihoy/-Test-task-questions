package com.example.testtaskquestions.presentation.finalScreen

import com.example.testtaskquestions.data.model.AnswerModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface FinalView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showAnswers(correctAnswers: Int, wrongAnswers: Int, answers: List<AnswerModel>)
}