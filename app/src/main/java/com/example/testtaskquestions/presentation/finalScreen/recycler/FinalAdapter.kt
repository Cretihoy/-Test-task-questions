package com.example.testtaskquestions.presentation.finalScreen.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskquestions.data.model.AnswerModel
import com.example.testtaskquestions.R

class FinalAdapter(
    private val context: Context
) : RecyclerView.Adapter<FinalViewHolder>() {

    private var items = listOf<AnswerModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_question, parent, false)
        return FinalViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FinalViewHolder, position: Int) {
        val answer = items[position]
        holder.run {
            questionText.text = context.getString(answer.question)
            isCorrect.text = "+".takeIf { answer.isCorrect } ?: "-"
            bookImage.setImageResource(answer.image)
        }
    }

    fun setItems(answers: List<AnswerModel>) {
        items = answers
        notifyItemInserted(items.lastIndex)
    }
}