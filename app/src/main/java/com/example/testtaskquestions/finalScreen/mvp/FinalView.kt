package com.example.testtaskquestions.finalScreen.mvp

import com.example.testtaskquestions.AnswerModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface FinalView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showAnswers(answer: List<AnswerModel>)
}