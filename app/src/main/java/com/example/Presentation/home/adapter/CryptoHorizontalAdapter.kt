package com.example.Presentation.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.model.CryptoCoin


class CryptoHorizontalAdapter() :
    ListAdapter<CryptoCoin, CryptoHorizontalViewHolder>(DefaultDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHorizontalViewHolder =
        CryptoHorizontalViewHolder.create(parent)


    override fun onBindViewHolder(holder: CryptoHorizontalViewHolder, position: Int) {
        getItem(position).also { holder.bind(cryptoCoinInfo = it) }
    }

    override fun getItemCount(): Int = 10

}

