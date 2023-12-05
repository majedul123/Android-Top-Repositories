package com.majedul.assignment.ui.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.majedul.assignment.data.model.Items
import com.majedul.mvvm.databinding.SearchItemBinding


class SearchAdapter(
    private val itemList: ArrayList<Items>
) : RecyclerView.Adapter<SearchAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Items) {
             binding.repositoryName.text = item.name
             binding.repositoryDescription.text = item.description
            Glide.with(binding.repositoryImage.context)
                .load(item.owner?.avatarUrl)
                .into(binding.repositoryImage)
//            binding.textViewDescription.text = article.description
//            binding.textViewSource.text = article.source.name
//            Glide.with(binding.imageViewBanner.context)
//                .load(article.imageUrl)
//                .into(binding.imageViewBanner)
//            itemView.setOnClickListener {
//                val builder = CustomTabsIntent.Builder()
//                val customTabsIntent = builder.build()
//                customTabsIntent.launchUrl(it.context, Uri.parse(article.url))
//            }
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