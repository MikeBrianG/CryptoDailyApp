package com.example.Presentation.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.TagDetailsScreenRecyclerItemBinding
import com.example.model.TagsInfo

class TagsInfoViewHolder(private val binding: TagDetailsScreenRecyclerItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(tagsInfo: TagsInfo) = with(binding) {
        textViewNameTagItem.text = tagsInfo.nameTag
    }

    companion object {
        fun create(parent: ViewGroup): TagsInfoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = TagDetailsScreenRecyclerItemBinding.inflate(inflater, parent, false)

            return TagsInfoViewHolder(binding)
        }
    }
}