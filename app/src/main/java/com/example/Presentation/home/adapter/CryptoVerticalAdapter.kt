package com.example.Presentation.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.CryptoCoin


class CryptoVerticalAdapter(
    private val cryptoCoinList: List<CryptoCoin>?
) :
    RecyclerView.Adapter<CryptoVerticalViewHolder>() {

    var implementationCardView: ClickAction? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoVerticalViewHolder {
        return CryptoVerticalViewHolder.create(parent)
    }


    override fun onBindViewHolder(holder: CryptoVerticalViewHolder, position: Int) {
        val coin = cryptoCoinList?.get(position)
        if (coin != null) {
            holder.bind(coin)
        }
        holder.listener = object : CryptoVerticalAdapterClickListener {
            override fun isFavoriteListener() {
                if (coin != null) {
                    coin.favorite = !coin.favorite
                }
                notifyItemChanged(holder.adapterPosition)
            }

            override fun cardViewClickListener() {

                if (coin != null) {
                    implementationCardView?.clickItemListListener(coin)
                }
            }
        }
    }

    override fun getItemCount(): Int = cryptoCoinList!!.size
}

interface ClickAction {
    fun clickItemListListener(coin: CryptoCoin)
}


