package com.example.Presentation.home

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import androidx.core.os.persistableBundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Presentation.home.adapter.ClickAction
import com.example.Presentation.home.adapter.CryptoHorizontalAdapter
import com.example.Presentation.home.adapter.CryptoVerticalAdapter
import com.example.R
import com.example.data.CryptoHomeRetrofit
import com.example.data.service.CryptoHomeService
import com.example.databinding.FragmentHomeScreenBinding
import com.example.model.CryptoCoin
import kotlinx.coroutines.launch
import kotlin.concurrent.thread


class HomeScreenFragment() : Fragment() {
    companion object {
        const val BASE_URL = "https://coingecko.com/api/v3/"
    }

    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var dialog: AlertDialog
    private lateinit var coin: CryptoCoin
    private var myCryptoList: List<CryptoCoin>? = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeScreenBinding.inflate(layoutInflater, container, false)
        if (myCryptoList?.size!! > 0 && !myCryptoList.isNullOrEmpty()) {
            setupHorizontalRecycler(myCryptoList)
            setupVerticalRecycler(myCryptoList)
        }

        getCryptoCoinList()
        setupListeners()


        return binding.root
    }

    fun setupHorizontalRecycler(cryptoCoinList: List<CryptoCoin>?) {
        val recyclerHorizontalCryptoCoin = binding.recyclerViewHorizontalList
        val adapter = CryptoHorizontalAdapter(cryptoCoinList)
        recyclerHorizontalCryptoCoin.adapter = adapter
    }
    private fun setupVerticalRecycler(cryptoCoinList: List<CryptoCoin>?) {
        val recyclerVerticalCryptoCoin = binding.recyclerViewVerticalList
        val adapter = CryptoVerticalAdapter(cryptoCoinList)
        recyclerVerticalCryptoCoin.adapter = adapter
        recyclerVerticalCryptoCoin.layoutManager = LinearLayoutManager(context)
        adapter.implementationCardView = object : ClickAction {

            override fun clickItemListListener(coin: CryptoCoin) {
                findNavController().navigate(R.id.action_fragment_Home_Screen_to_coinDetails)
            }
        }
    }
    private fun getCryptoCoinList() {
        lifecycleScope.launch {
            val retrofit = CryptoHomeRetrofit.getCryptoRetrofit()
            myCryptoList = retrofit.create(CryptoHomeService::class.java)
                .getCryptoCoin()
                .body()
            setupHorizontalRecycler(myCryptoList)
            setupVerticalRecycler(myCryptoList)
        }
    }


    private fun filteredFavoriteList(cryptoCoinList: List<CryptoCoin>?) {
        val favoriteList = cryptoCoinList?.filter { it.favorite }
        setupVerticalRecycler(favoriteList)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupFavoriteView() {
        binding.run {
            buttonViewAllHomeScreen.visibility = View.GONE
            textViewTop10HomeScreen.visibility = View.GONE
            recyclerViewHorizontalList.visibility = View.GONE
            textViewCryptocoinsListHomeScreen.text = "Favorites"
            textViewOnlyFavoritesBottomBar.setTextColor(
                textViewOnlyFavoritesBottomBar.context.getColor(R.color.white)
            )
            textViewAllBottomBar.setTextColor(
                textViewAllBottomBar.context.getColor(R.color.white_50)
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
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

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupListeners() {

        binding.run {
            buttonExitHomeScreen.setOnClickListener {
                showAlertDialog()
            }
            textViewAllBottomBar.setOnClickListener {
                setupVerticalRecycler(myCryptoList)
                setupAllListView()
            }
            textViewOnlyFavoritesBottomBar.setOnClickListener {
                filteredFavoriteList(myCryptoList)
                setupFavoriteView()
            }
        }
    }
    private fun setFavoriteFilter(): List<CryptoCoin>? {
        return myCryptoList?.filter { it.favorite }
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





