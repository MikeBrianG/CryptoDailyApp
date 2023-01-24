package com.example.Presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.R
import com.example.databinding.FragmentAccessScreenBinding

class AccessScreenFragment : Fragment() {

    private lateinit var binding: FragmentAccessScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccessScreenBinding.inflate(layoutInflater, container, false)
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.run {
            buttonLoginInitialScreen.setOnClickListener {
                navigateScreen(R.id.action_firstScreenFragment_to_loginScreenFragment)
            }
            buttonSignUpInitialScreen.setOnClickListener {
                navigateScreen(R.id.action_firstScreenFragment_to_createAccountScreenFragment)
            }
        }
    }

    private fun navigateScreen(screen: Int) {
        findNavController().navigate(screen)
    }
}