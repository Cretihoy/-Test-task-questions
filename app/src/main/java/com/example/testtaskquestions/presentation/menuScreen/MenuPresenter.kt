package com.example.testtaskquestions.presentation.menuScreen

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MenuPresenter
@Inject constructor() : MvpPresenter<MenuView>() {

    fun onButtonClicked() {
        viewState.openGameScreen()
    }
}