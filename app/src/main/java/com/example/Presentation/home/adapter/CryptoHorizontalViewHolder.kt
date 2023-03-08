package com.example.Presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.CryptoRecyclerHorizontalItemBinding

import com.example.model.CryptoCoin

class CryptoHorizontalViewHolder(private val binding: CryptoRecyclerHorizontalItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(cryptoCoinInfo: CryptoCoin) = with(binding) {
        textViewNameCoin.text = cryptoCoinInfo.name
        textViewAcronymCoin.text = cryptoCoinInfo.symbol
        textViewPriceCoin.text = cryptoCoinInfo.currentPrice
    }

    companion object {
        fun create(parent: ViewGroup): CryptoHorizontalViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = CryptoRecyclerHorizontalItemBinding.inflate(inflater, parent, false)

            return CryptoHorizontalViewHolder(binding)
        }
    }
}

