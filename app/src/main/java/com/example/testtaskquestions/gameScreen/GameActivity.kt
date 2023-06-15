package com.example.testtaskquestions.gameScreen

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.testtaskquestions.R
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class GameActivity : MvpAppCompatActivity(), GameView {

    val questionText: TextView by lazy { findViewById(R.id.text_activity_game) }
    val firstBookImage: ImageView by lazy { findViewById(R.id.book_1_activity_game) }
    val secondBookImage: ImageView by lazy { findViewById(R.id.book_2_activity_game) }
    val thirdBookImage: ImageView by lazy { findViewById(R.id.book_3_activity_game) }

    @Inject
    lateinit var presenterProvider: Provider<GamePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}