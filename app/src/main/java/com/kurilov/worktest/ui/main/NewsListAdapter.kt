package com.kurilov.worktest.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kurilov.worktest.R
import com.kurilov.worktest.data.classes.Article
import com.squareup.picasso.Picasso

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {

    private var items : List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_news_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.newsTittleImageView.text = item.title
        holder.newsPublishingDate.text = "Дата публикации: " +
                item.publishedAt.substringBefore("T") + " " +
                item.publishedAt.substringAfter("T").substringBefore("Z")
        Picasso.get()
            .load(item.urlToImage)
            .error(R.drawable.no_image)
            .placeholder(R.drawable.no_image)
            .into(holder.newsImageView)

    }

    fun updateItems(items: List<Article>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newsImageView: ImageView = itemView.findViewById(R.id.newsImageView)
        var newsTittleImageView: TextView = itemView.findViewById(R.id.newsTitleTextView)
        var newsPublishingDate: TextView = itemView.findViewById(R.id.newsPublishingDateTextView)
    }

    override fun getItemCount() = items.size
}