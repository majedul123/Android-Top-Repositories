package com.majedul.assignment.ui.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.majedul.assignment.data.model.Items
import com.majedul.mvvm.databinding.SearchItemBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SearchAdapter(
    private val itemList: ArrayList<Items>
) : RecyclerView.Adapter<SearchAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items) {
            binding.repositoryName.text = item.name
            binding.repositoryDescription.text = item.description
            Glide.with(binding.repositoryImage.context)
                .load(item.owner?.avatarUrl)
                .into(binding.repositoryImage)
            binding.languageName.text = item.language
            val startCount = (item.stargazersCount)?.div(1000)
            binding.startCount.text = "$startCount K"

            val updateTime = item.updatedAt
            val timeDifferenceMillis = System.currentTimeMillis() - SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(updateTime).time
            val timeAgo = android.text.format.DateUtils.getRelativeTimeSpanString(System.currentTimeMillis() - timeDifferenceMillis, System.currentTimeMillis(), android.text.format.DateUtils.MINUTE_IN_MILLIS)


            binding.updateTime.text = "Updated $timeAgo "
            val languageAdapter = TopicsAdapter( item.topics)
            binding.topicsList.layoutManager =
                GridLayoutManager(itemView.context, 4, RecyclerView.HORIZONTAL, false)

            binding.topicsList.adapter = languageAdapter

            itemView.setOnClickListener {
              //  itemView.rootView.context.startActivity(Intent (itemView.rootView.context,RepositoryDetailsActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(itemList[position])

    fun addData(list: List<Items>) {
        itemList.addAll(list)
    }

}