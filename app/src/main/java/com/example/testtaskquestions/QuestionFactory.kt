package com.example.testtaskquestions

import javax.inject.Inject

class QuestionFactory
@Inject constructor(
    private val bookFactory: BookFactory
) {
    fun getQuestionList(): List<QuestionModel> {
        val books = bookFactory.getBookList()
        return books.map {
            makeQuestion(it)
        }
    }

    private fun makeQuestion(book: BookModel): QuestionModel {
        val firstIncorrectBook = getRandomBook(book)
        val secondIncorrectBook = getRandomBook(book, firstIncorrectBook)
        val books = mutableListOf(book, firstIncorrectBook, secondIncorrectBook)
        books.shuffle()
        return QuestionModel(
            correctBook = book,
            books = books
        )
    }

    private fun getRandomBook(
        firstBook: BookModel,
        secondBook: BookModel? = null,
    ): BookModel {
        val books = bookFactory.getBookList()
        val filteredBooks = books.filter { it != firstBook && it != secondBook }
        return filteredBooks.random()
    }
}