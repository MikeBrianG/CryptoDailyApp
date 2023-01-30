package com.example.Presentation.details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.TagsInfo

class TagsInfoAdapter(private val tagsInfo: MutableList<TagsInfo>) :
    RecyclerView.Adapter<TagsInfoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsInfoViewHolder {

        return TagsInfoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TagsInfoViewHolder, position: Int) {
        val tags = tagsInfo[position]
        holder.bind(tags)
    }

    override fun getItemCount(): Int = tagsInfo.size
}