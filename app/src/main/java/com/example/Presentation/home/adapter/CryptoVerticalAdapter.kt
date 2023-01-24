package com.example.Presentation.home.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.databinding.CryptoRecyclerVerticalItemBinding
import com.example.model.CryptoCoin
import com.example.model.coins

class CryptoVerticalAdapter(
    private val cryptoCoin: MutableList<CryptoCoin>
) :
    RecyclerView.Adapter<CryptoVerticalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoVerticalViewHolder {

        return CryptoVerticalViewHolder.create(parent)
    }


    override fun onBindViewHolder(holder: CryptoVerticalViewHolder, position: Int) {
        val coins = cryptoCoin[position]
        holder.bind(coins)

        holder.listener = object : CryptoVerticalAdapterClickListener {
            override fun isFavoriteListener() {
                coins.favoriteSelected = !coins.favoriteSelected
                notifyItemChanged(holder.adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int = cryptoCoin.size
}


