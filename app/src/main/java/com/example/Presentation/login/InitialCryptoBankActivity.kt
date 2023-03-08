package com.example.Presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.databinding.ActivityFirstScreenBinding


class InitialCryptoBankActivity : AppCompatActivity() {
    companion object {
        const val BASE_URL = "https://coingecko.com/api/v3/"
    }

    private lateinit var binding: ActivityFirstScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
