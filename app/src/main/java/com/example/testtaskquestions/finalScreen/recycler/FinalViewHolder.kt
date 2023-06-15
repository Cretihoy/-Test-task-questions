package com.example.testtaskquestions.finalScreen.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskquestions.R

class FinalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val questionText: TextView by lazy { itemView.findViewById(R.id.item_text_question) }
    val isCorrect: TextView by lazy { itemView.findViewById(R.id.item_text_correctness) }
    val bookImage: ImageView by lazy { itemView.findViewById(R.id.item_image) }
}