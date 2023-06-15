package com.example.testtaskquestions

import javax.inject.Inject

class BookFactory
@Inject constructor() {
    fun getBookList(): List<BookModel> {
        return listOf(
            BookModel(R.drawable.book_1, R.string.harry_potter),
            BookModel(R.drawable.book_2, R.string.alice_adventure),
            BookModel(R.drawable.book_3, R.string.gulliver_travels),
            BookModel(R.drawable.book_4, R.string.king_arthur_sword),
            BookModel(R.drawable.book_5, R.string.witcher),
            BookModel(R.drawable.book_6, R.string.game_of_thrones),
            BookModel(R.drawable.book_7, R.string.twilight),
            BookModel(R.drawable.book_8, R.string.dark_tower),
            BookModel(R.drawable.book_9, R.string.walking_castle),
            BookModel(R.drawable.book_10, R.string.the_chronicles_of_narnia),
        )
    }
}