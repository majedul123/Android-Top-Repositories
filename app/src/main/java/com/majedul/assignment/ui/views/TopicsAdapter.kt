package com.majedul.assignment.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.majedul.mvvm.R


class TopicsAdapter(private val topics: List<String>) :
    RecyclerView.Adapter<TopicsAdapter.InnerLanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerLanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topics_item, parent, false)
        return InnerLanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: InnerLanguageViewHolder, position: Int) {
        holder.bind(topics[position])

    }

    override fun getItemCount(): Int {
        return topics.size
    }

    inner class InnerLanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val languageInnerTextView: TextView = itemView.findViewById(R.id.topicsTextView)

        fun bind(topic: String) {
            languageInnerTextView.text = topic
        }
    }
}