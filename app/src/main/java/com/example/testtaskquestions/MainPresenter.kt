package com.example.testtaskquestions

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter
@Inject constructor() : MvpPresenter<MainView>() {
}