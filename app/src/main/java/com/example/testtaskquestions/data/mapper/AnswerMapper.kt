package com.example.testtaskquestions.data.mapper

import com.example.testtaskquestions.data.model.AnswerModel
import com.example.testtaskquestions.data.model.BookModel
import com.example.testtaskquestions.data.model.QuestionModel
import javax.inject.Inject

class AnswerMapper
@Inject constructor() {

    fun map(
        book: BookModel,
        question: QuestionModel,
    ): AnswerModel {
        val isCorrect = book == question.correctBook
        return AnswerModel(
            quote = question.correctBook.quote,
            isCorrect = isCorrect,
            image = question.correctBook.image
        )
    }
}