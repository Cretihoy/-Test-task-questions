package com.example.testtaskquestions.presentation.finalScreen

import com.example.testtaskquestions.data.repository.AnswersRepository
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class FinalPresenter
@Inject constructor(
    private val answersRepository: AnswersRepository,
) : MvpPresenter<FinalView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val correctAnswers = answersRepository.getCorrectAnswersCount()
        val wrongAnswers = answersRepository.getWrongAnswersCount()
        val answers = answersRepository.getAnswers()
        viewState.showAnswers(correctAnswers, wrongAnswers, answers)
    }

    fun onRestartClicked() {
        viewState.openNewGameScreen()
    }
}
