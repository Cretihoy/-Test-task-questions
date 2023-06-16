package com.example.testtaskquestions.data.mapper

import com.example.testtaskquestions.data.model.BookModel
import com.example.testtaskquestions.data.model.QuestionModel
import javax.inject.Inject

class QuestionMapper
@Inject constructor() {

    fun map(books: List<BookModel>): List<QuestionModel> {
        return books.map {
            makeQuestion(books, it)
        }
    }

    private fun makeQuestion(
        books: List<BookModel>,
        currentBook: BookModel,
    ): QuestionModel {
        val firstIncorrectBook = getRandomBook(books, currentBook)
        val secondIncorrectBook = getRandomBook(books, currentBook, firstIncorrectBook)
        val questionBooks = mutableListOf(currentBook, firstIncorrectBook, secondIncorrectBook)
        questionBooks.shuffle()
        return QuestionModel(
            correctBook = currentBook,
            books = questionBooks
        )
    }

    private fun getRandomBook(
        books: List<BookModel>,
        firstBook: BookModel,
        secondBook: BookModel? = null,
    ): BookModel {
        val filteredBooks = books.filter { it != firstBook && it != secondBook }
        return filteredBooks.random()
    }
}