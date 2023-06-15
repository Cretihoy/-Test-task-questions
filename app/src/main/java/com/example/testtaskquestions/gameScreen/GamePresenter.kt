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


}