package com.example.Presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.databinding.CryptoRecyclerVerticalItemBinding
import com.example.model.CryptoCoin

class CryptoVerticalViewHolder(private val binding: CryptoRecyclerVerticalItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    var listener: CryptoVerticalAdapterClickListener? = null

    fun bind(cryptoCoin: CryptoCoin) = with(binding) {
        clickFavoriteButton()
        textViewNameCoin.text = cryptoCoin.nameCoin
        textViewAcronymCoin.text = cryptoCoin.acronymCoin
        textViewPriceCoin.text = cryptoCoin.priceCoin.toString()
        binding.imageButtonFavoriteIconEmpty.setBackgroundResource(setupBackground(cryptoCoin))
    }

    private fun setupBackground(coin: CryptoCoin): Int = if (coin.favoriteSelected) {
        R.drawable.favorite_icon_vector
    } else {
        R.drawable.empty_favorite_icon_vector
    }


    private fun clickFavoriteButton() {
        binding.imageButtonFavoriteIconEmpty.setOnClickListener {
            listener?.isFavoriteListener()
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

}