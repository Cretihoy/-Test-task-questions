package com.example.testtaskquestions.gameScreen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.testtaskquestions.QuestionModel
import com.example.testtaskquestions.R
import com.example.testtaskquestions.finalScreen.mvp.CORRECT_ANSWERS_KEY
import com.example.testtaskquestions.finalScreen.mvp.FinalActivity
import com.example.testtaskquestions.finalScreen.mvp.WRONG_ANSWERS_KEY
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class GameActivity : MvpAppCompatActivity(), GameView {

    private val questionText: TextView by lazy { findViewById(R.id.game_text_quiz) }
    private val firstBookImage: ImageView by lazy { findViewById(R.id.game_image_first_book) }
    private val secondBookImage: ImageView by lazy { findViewById(R.id.game_image_second_book) }
    private val thirdBookImage: ImageView by lazy { findViewById(R.id.game_image_third_book) }

    @Inject
    lateinit var presenterProvider: Provider<GamePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        firstBookImage.setOnClickListener {
            presenter.onBookPressed(0)
        }
        secondBookImage.setOnClickListener {
            presenter.onBookPressed(1)
        }
        thirdBookImage.setOnClickListener {
            presenter.onBookPressed(2)
        }
    }

    override fun showQuestion(question: QuestionModel) {
        questionText.text = getString(question.correctBook.stroke)
        firstBookImage.setImageResource(question.books[0].image)
        secondBookImage.setImageResource(question.books[1].image)
        thirdBookImage.setImageResource(question.books[2].image)
    }

    override fun openFinalScreen(correctAnswers: Int, wrongAnswers: Int) {
        val intent = Intent(this, FinalActivity::class.java)
        intent.putExtra(CORRECT_ANSWERS_KEY, correctAnswers)
        intent.putExtra(WRONG_ANSWERS_KEY, wrongAnswers)
        startActivity(intent)
    }
}