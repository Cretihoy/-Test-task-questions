package com.example.testtaskquestions.data.repository

import com.example.testtaskquestions.data.mapper.AnswerMapper
import com.example.testtaskquestions.data.model.AnswerModel
import com.example.testtaskquestions.data.model.BookModel
import com.example.testtaskquestions.data.model.QuestionModel
import javax.inject.Inject

class AnswersRepository
@Inject constructor(
    private val answerMapper: AnswerMapper,
) {

    private val answersList = mutableListOf<AnswerModel>()

    fun addAnswer(
        book: BookModel,
        question: QuestionModel,
    ) {
        val answer = answerMapper.map(book, question)
        answersList.add(answer)
    }

    fun getCorrectAnswersCount(): Int {
        return answersList.filter { it.isCorrect }.size
    }

    fun getWrongAnswersCount(): Int {
        return answersList.filter { !it.isCorrect }.size
    }
}