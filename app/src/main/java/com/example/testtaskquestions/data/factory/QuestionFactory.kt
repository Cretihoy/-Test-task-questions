package com.example.testtaskquestions.data.factory

import com.example.testtaskquestions.data.mapper.QuestionMapper
import com.example.testtaskquestions.data.model.QuestionModel
import javax.inject.Inject

class QuestionFactory
@Inject constructor(
    private val bookFactory: BookFactory,
    private val questionMapper: QuestionMapper,
) {

    fun getQuestionList(): List<QuestionModel> {
        val books = bookFactory.getBookList()
        return questionMapper.map(books)
    }
}