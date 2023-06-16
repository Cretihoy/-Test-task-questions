package com.example.testtaskquestions.presentation.finalScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskquestions.R
import com.example.testtaskquestions.data.model.AnswerModel
import com.example.testtaskquestions.presentation.finalScreen.recycler.FinalAdapter
import com.example.testtaskquestions.presentation.gameScreen.GameActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class FinalActivity : MvpAppCompatActivity(), FinalView {

    private val restartButton: Button by lazy { findViewById(R.id.final_button_play) }
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
        restartButton.setOnClickListener {
            presenter.onRestartClicked()
        }
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

    override fun openNewGameScreen() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}