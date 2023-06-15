package com.example.testtaskquestions.finalScreen

import android.os.Bundle
import com.example.testtaskquestions.R
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class FinalActivity : MvpAppCompatActivity(), FinalView {

    @Inject
    lateinit var presenterProvider: Provider<FinalPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
    }
}