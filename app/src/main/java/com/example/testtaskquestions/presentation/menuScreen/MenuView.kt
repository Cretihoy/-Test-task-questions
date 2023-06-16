package com.example.testtaskquestions.presentation.menuScreen

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MenuView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun openGameScreen()
}