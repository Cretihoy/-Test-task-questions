package com.example.testtaskquestions.presentation.finalScreen

import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskquestions.R
import com.example.testtaskquestions.data.model.AnswerModel
import com.example.testtaskquestions.presentation.finalScreen.recycler.FinalAdapter
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class FinalActivity : MvpAppCompatActivity(), FinalView {

    private val correctAnswersText: TextView by lazy { findViewById(R.id.final_text_correct_answer) }
    private val wrongAnswersText: TextView by lazy { findViewById(R.id.final_text_wrong_answer) }
    private val recycler: RecyclerView by lazy { findViewById(R.id.final_recycler) }
    private val adapter = FinalAdapter(this)

    @Inject
    lateinit var presenterProvider: Provider<FinalPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        recycler.adapter = adapter
    }

    override fun showAnswers(
        correctAnswers: Int,
        wrongAnswers: Int,
        answers: List<AnswerModel>,
    ) {
        adapter.setItems(answers)
        correctAnswersText.text = getString(R.string.correct_answers, correctAnswers)
        wrongAnswersText.text = getString(R.string.wrong_answers, wrongAnswers)
    }
}