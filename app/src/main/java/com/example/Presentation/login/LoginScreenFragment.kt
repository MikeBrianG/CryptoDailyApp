package com.example.Presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.Presentation.home.HomePageActivity
import com.example.R
import com.example.databinding.FragmentLoginScreenBinding


class LoginScreenFragment : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginScreenBinding.inflate(layoutInflater, container, false)
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.run {
            buttonBackLoginScreen.setOnClickListener {
                navigateScreen(R.id.action_loginScreenFragment_to_firstScreenFragment)

            }
            buttonSignUpLoginScreen.setOnClickListener {
                navigateScreen(R.id.action_loginScreenFragment_to_createAccountScreenFragment)

            }
            loginButtonLoginScreen.setOnClickListener {
                startActivity(Intent(context, HomePageActivity::class.java))
            }
        }
    }

    private fun navigateScreen(screen: Int) {
        findNavController().navigate(screen)
    }
}