package com.example.Presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.R
import com.example.databinding.FragmentCreateAccountScreenBinding

class SignUpScreenFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCreateAccountScreenBinding.inflate(layoutInflater, container, false)
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.run {
            buttonCreateAccountSignUpScreen.setOnClickListener {
                navigateScreen(R.id.action_createAccountScreenFragment_to_loginScreenFragment3)
            }
            buttonAlredyRegisteredSignUpScreen.setOnClickListener {
                navigateScreen(R.id.action_createAccountScreenFragment_to_loginScreenFragment3)
            }
            buttonBackSignUpScreen.setOnClickListener {
                navigateScreen(R.id.action_createAccountScreenFragment_to_firstScreenFragment)
            }
        }
    }

    private fun navigateScreen (screen: Int) {
        findNavController().navigate(screen)
    }
}