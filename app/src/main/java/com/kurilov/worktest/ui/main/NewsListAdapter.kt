package com.kurilov.worktest.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kurilov.worktest.R
import com.kurilov.worktest.data.classes.News
import com.squareup.picasso.Picasso

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {

    private var items : List<News> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_news_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        //holder.newsTittleImageView.text = item.name.common
        //Picasso.get()
        //    .load(item.flags.png)
        //    .into(holder.newsImageView)

    }

    fun updateItems(items: List<News>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newsImageView: ImageView = itemView.findViewById(R.id.newsImageView)
        var newsTittleImageView: TextView = itemView.findViewById(R.id.newsTitleTextView)
    }

    override fun getItemCount() = items.size
}