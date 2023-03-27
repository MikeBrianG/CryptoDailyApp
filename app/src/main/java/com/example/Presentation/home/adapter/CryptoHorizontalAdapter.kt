package com.example.Presentation.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.CryptoCoin


class CryptoHorizontalAdapter(private val cryptoCoinList: List<CryptoCoin>?) :
    RecyclerView.Adapter<CryptoHorizontalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHorizontalViewHolder =
        CryptoHorizontalViewHolder.create(parent)

    override fun onBindViewHolder(holder: CryptoHorizontalViewHolder, position: Int) {
        val coin = cryptoCoinList?.get(position)
        if (coin != null) {
            holder.bind(coin)

        }
    }
    override fun getItemCount(): Int = cryptoCoinList!!.size.and(10)

}



