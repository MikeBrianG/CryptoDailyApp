package com.example.Presentation.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.R
import com.example.data.CryptoRetrofit
import com.example.data.service.CryptoInfoService
import com.example.databinding.FragmentCoinDetailsBinding
import com.example.model.*
import kotlinx.coroutines.launch

class CoinDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCoinDetailsBinding
    private lateinit var coinId: String
    private lateinit var coinInfo: CryptoCoinInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinDetailsBinding.inflate(layoutInflater, container, false)
        val args: CoinDetailsFragmentArgs by navArgs()
        coinId = args.coinId
        getCryptoInfoDetails()
        setupListeners()

        return binding.root
    }

    private fun getCryptoInfoDetails() {
        lifecycleScope.launch {
            val cryptoDetailService = CryptoRetrofit.getCryptoRetrofit()
                .create(CryptoInfoService::class.java)
            val coinInfoDetail = cryptoDetailService.getCryptoCoinInfo(coinId).body()
            binding.textViewNameCoinIdTitle.text = coinInfoDetail?.name
            binding.textViewDescriptionDetailScreen.text = coinInfoDetail?.description?.en ?: ""
            Log.i("currentPrice", "${coinInfoDetail?.marketData?.currentPrice}")
            if (coinInfoDetail != null) {
                coinInfo = coinInfoDetail
            }
            setupView()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupView() {
        binding.textViewCurrentPrice.text =
            convertCurrentPriceToUiModel(CurrentCoinType.USD, coinInfo.marketData.currentPrice.usd)

    }

    private fun setupListeners() {
        binding.run {
            backButtonDetailsHomeScreen.setOnClickListener {
                findNavController().navigate(R.id.action_coinDetails_to_fragment_Home_Screen)
            }
            chipGroupButton1Usd.setOnClickListener {
                setValueCurrentPrice(CurrentCoinType.USD, coinInfo.marketData.currentPrice.usd)
            }
            chipGroupButton2Eur.setOnClickListener {
                setValueCurrentPrice(CurrentCoinType.EUR, coinInfo.marketData.currentPrice.eur)
            }
            chipGroupButton3Brl.setOnClickListener {
                setValueCurrentPrice(CurrentCoinType.BRL, coinInfo.marketData.currentPrice.brl)
            }
            chipGroupButton4Btc.setOnClickListener {
                setValueCurrentPrice(CurrentCoinType.BTC, coinInfo.marketData.currentPrice.btc)
            }
            chipGroupButton5Eth.setOnClickListener {
                setValueCurrentPrice(CurrentCoinType.ETH, coinInfo.marketData.currentPrice.eth)
            }
            chipGroupButton6Jpy.setOnClickListener {
                setValueCurrentPrice(CurrentCoinType.JPY, coinInfo.marketData.currentPrice.jpy)
            }
        }
    }

    private fun setValueCurrentPrice(currentCoinType: CurrentCoinType, value: Double) {
        binding.textViewCurrentPrice.text = convertCurrentPriceToUiModel(currentCoinType, value)
    }
}


