package com.example.Presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.databinding.CryptoRecyclerVerticalItemBinding
import com.example.model.CryptoCoin

class CryptoVerticalViewHolder(private val binding: CryptoRecyclerVerticalItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    var listener: CryptoVerticalAdapterClickListener? = null


    @SuppressLint("SetTextI18n")
    fun bind(cryptoCoin: CryptoCoin) = with(binding) {
        setupListener()
        textViewNameCoin.text = cryptoCoin.name
        textViewAcronymCoin.text = cryptoCoin.symbol
        textViewPriceCoin.text = cryptoCoin.currentPrice + " $"
        binding.imageButtonFavoriteIconEmpty.setBackgroundResource(setupBackground(cryptoCoin))
    }

    private fun setupBackground(coin: CryptoCoin): Int = if (coin.favorite) {
        R.drawable.favorite_icon_vector
    } else {
        R.drawable.empty_favorite_icon_vector
    }

    private fun setupListener() {
        binding.imageButtonFavoriteIconEmpty.setOnClickListener {
            listener?.isFavoriteListener()
        }
        binding.cardViewVerticalItemRecycler.setOnClickListener {
            listener?.cardViewClickListener()
        }
    }

    companion object {
        fun create(parent: ViewGroup): CryptoVerticalViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = CryptoRecyclerVerticalItemBinding.inflate(inflater, parent, false)

            return CryptoVerticalViewHolder(binding)
        }
    }
}

interface CryptoVerticalAdapterClickListener {
    fun isFavoriteListener()
    fun cardViewClickListener()
}

