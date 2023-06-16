package com.example.testtaskquestions.presentation.finalScreen.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskquestions.R
import com.example.testtaskquestions.data.model.AnswerModel

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
            val imageResId = R.drawable.ic_check.takeIf { answer.isCorrect } ?: R.drawable.ic_error
            questionText.text = context.getString(answer.quote)
            isCorrect.setImageResource(imageResId)
            bookImage.setImageResource(answer.image)
        }
    }

    fun setItems(answers: List<AnswerModel>) {
        items = answers
        notifyItemInserted(items.lastIndex)
    }
}