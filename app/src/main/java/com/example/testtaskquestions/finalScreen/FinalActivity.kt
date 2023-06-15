package com.example.testtaskquestions.finalScreen

import android.os.Bundle
import android.widget.TextView
import com.example.testtaskquestions.R
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

const val CORRECT_ANSWERS_KEY = "CORRECT_ANSWERS"
const val WRONG_ANSWERS_KEY = "WRONG_ANSWERS"

@AndroidEntryPoint
class FinalActivity : MvpAppCompatActivity(), FinalView {

    private val correctAnswersText: TextView by lazy { findViewById(R.id.final_text_correct_answer) }
    private val wrongAnswersText: TextView by lazy { findViewById(R.id.final_text_wrong_answer) }
    private val correctAnswers by lazy { intent.getIntExtra(CORRECT_ANSWERS_KEY, 0) }
    private val wrongAnswers by lazy { intent.getIntExtra(WRONG_ANSWERS_KEY, 0) }

    @Inject
    lateinit var presenterProvider: Provider<FinalPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        correctAnswersText.text = getString(R.string.correct_answers, correctAnswers)
        wrongAnswersText.text = getString(R.string.wrong_answers, wrongAnswers)
    }
}