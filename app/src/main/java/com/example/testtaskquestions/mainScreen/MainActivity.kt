package com.example.testtaskquestions.mainScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.testtaskquestions.R
import com.example.testtaskquestions.gameScreen.GameActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : MvpAppCompatActivity(), MainView {

    private val buttonPlay: Button by lazy { findViewById(R.id.button_activity_main) }

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlay.setOnClickListener {
            presenter.onButtonClicked()
        }
    }

    override fun openGameScreen() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}