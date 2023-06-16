package com.example.testtaskquestions.presentation.menuScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.testtaskquestions.R
import com.example.testtaskquestions.presentation.gameScreen.GameActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MenuActivity : MvpAppCompatActivity(), MenuView {

    private val buttonPlay: Button by lazy { findViewById(R.id.main_button_play) }

    @Inject
    lateinit var presenterProvider: Provider<MenuPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonPlay.setOnClickListener {
            presenter.onButtonClicked()
        }
    }

    override fun openGameScreen() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}