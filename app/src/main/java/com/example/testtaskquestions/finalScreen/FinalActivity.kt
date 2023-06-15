package com.example.testtaskquestions.finalScreen

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testtaskquestions.R

const val CORRECT_ANSWERS_KEY = "CORRECT_ANSWERS"
const val WRONG_ANSWERS_KEY = "WRONG_ANSWERS"

class FinalActivity : AppCompatActivity() {

    private val correctAnswersText: TextView by lazy { findViewById(R.id.final_text_correct_answer) }
    private val wrongAnswersText: TextView by lazy { findViewById(R.id.final_text_wrong_answer) }
    private val correctAnswers by lazy { intent.getIntExtra(CORRECT_ANSWERS_KEY, 0) }
    private val wrongAnswers by lazy { intent.getIntExtra(WRONG_ANSWERS_KEY, 0) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        correctAnswersText.text = getString(R.string.correct_answers, correctAnswers)
        wrongAnswersText.text = getString(R.string.wrong_answers, wrongAnswers)
    }
}