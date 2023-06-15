package com.example.testtaskquestions.gameScreen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.testtaskquestions.QuestionModel
import com.example.testtaskquestions.R
import com.example.testtaskquestions.finalScreen.FinalActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class GameActivity : MvpAppCompatActivity(), GameView {

    private val questionText: TextView by lazy { findViewById(R.id.text_activity_game) }
    private val firstBookImage: ImageView by lazy { findViewById(R.id.book_1_activity_game) }
    private val secondBookImage: ImageView by lazy { findViewById(R.id.book_2_activity_game) }
    private val thirdBookImage: ImageView by lazy { findViewById(R.id.book_3_activity_game) }

    @Inject
    lateinit var presenterProvider: Provider<GamePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        firstBookImage.setOnClickListener {
            presenter.onBookPressed()
        }
        secondBookImage.setOnClickListener {
            presenter.onBookPressed()
        }
        thirdBookImage.setOnClickListener {
            presenter.onBookPressed()
        }
    }

    override fun showQuestion(question: QuestionModel) {
        questionText.text = getString(question.correctBook.stroke)
        firstBookImage.setImageResource(question.books[0].image)
        secondBookImage.setImageResource(question.books[1].image)
        thirdBookImage.setImageResource(question.books[2].image)
    }

    override fun openFinalScreen() {
        val intent = Intent(this, FinalActivity::class.java)
        startActivity(intent)
    }
}