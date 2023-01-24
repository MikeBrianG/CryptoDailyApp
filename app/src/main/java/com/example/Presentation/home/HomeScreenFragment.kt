package com.example.Presentation.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Presentation.home.adapter.CryptoHorizontalAdapter
import com.example.Presentation.home.adapter.CryptoVerticalAdapter
import com.example.R
import com.example.databinding.FragmentHomeScreenBinding
import com.example.model.CryptoCoin
import com.example.model.coins


class HomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeScreenBinding.inflate(layoutInflater, container, false)
        setupHorizontalRecycler()
        setupVerticalRecycler(coins)
        setListeners()

        return binding.root


    }

    private fun setupHorizontalRecycler() {
        val recyclerHorizontalCryptoCoin = binding.recyclerViewHorizontalList
        val adapter = CryptoHorizontalAdapter()
        adapter.submitList(coins.sortedByDescending { it.priceCoin })
        recyclerHorizontalCryptoCoin.adapter = adapter

    }


    private fun setupVerticalRecycler(cryptoCoinList: MutableList<CryptoCoin>) {
        val recyclerVerticalCryptoCoin = binding.recyclerViewVerticalList
        val adapter = CryptoVerticalAdapter(cryptoCoinList)
        recyclerVerticalCryptoCoin.adapter = adapter
        recyclerVerticalCryptoCoin.layoutManager = LinearLayoutManager(context)

    }

    private fun myFavoriteList(cryptoCoinList: MutableList<CryptoCoin>) {
        val myFavoriteList = mutableListOf<CryptoCoin>()
        myFavoriteList.addAll(cryptoCoinList)
        setupVerticalRecycler(myFavoriteList)
    }

    private fun setupFavoriteView() {
        binding.run {
            buttonViewAllHomeScreen.visibility = View.GONE
            textViewTop10HomeScreen.visibility = View.GONE
            recyclerViewHorizontalList.visibility = View.GONE
            textViewCryptocoinsListHomeScreen.text = "Favorites"
            textViewOnlyFavoritesBottomBar.setTextColor(
                textViewOnlyFavoritesBottomBar.getContext().getColor(R.color.white)
            )
            textViewAllBottomBar.setTextColor(
                textViewAllBottomBar.context.getColor(R.color.white_50)
            )
        }
    }

    private fun setupAllListView() {
        binding.run {
            buttonViewAllHomeScreen.visibility = View.VISIBLE
            textViewTop10HomeScreen.visibility = View.VISIBLE
            recyclerViewHorizontalList.visibility = View.VISIBLE
            textViewCryptocoinsListHomeScreen.text = "CryptoCoin list"
            textViewOnlyFavoritesBottomBar.setTextColor(
                textViewOnlyFavoritesBottomBar.context.getColor(R.color.white_50)
            )
            textViewAllBottomBar.setTextColor(
                textViewAllBottomBar.context.getColor(R.color.white)
            )

        }
    }


    private fun setListeners() {
        binding.run {
            buttonExitHomeScreen.setOnClickListener {
                showAlertDialog()
            }
            textViewAllBottomBar.setOnClickListener {
                myFavoriteList(coins)
                setupAllListView()
            }
            textViewOnlyFavoritesBottomBar.setOnClickListener {
                myFavoriteList(setFavoriteFilter())
                setupFavoriteView()
            }

        }
    }


    private fun setFavoriteFilter(): MutableList<CryptoCoin> {
        return coins.filter { it.favoriteSelected } as MutableList<CryptoCoin>
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(context, R.style.Theme_CryptoAlertDialog)
        val view = layoutInflater.inflate(R.layout.alert_dialog_exit, null)
        builder.setView(view)

        val cancelButton = view.findViewById<AppCompatButton>(R.id.cancel_button_dialog_alert)
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        val exitButton = view.findViewById<AppCompatButton>(R.id.exit_button_dialog_alert)
        exitButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Home_Screen_to_initialScreenFragment)
            dialog.dismiss()
            activity!!.finish()

        }
        dialog = builder.create()
        dialog.show()
    }

}
