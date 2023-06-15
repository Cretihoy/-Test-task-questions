package com.example.testtaskquestions.mainScreen

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter
@Inject constructor() : MvpPresenter<MainView>() {

    fun onButtonClicked() {
        viewState.openGameScreen()
    }
}