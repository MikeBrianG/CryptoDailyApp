package com.example.Presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Presentation.details.adapter.TagsInfoAdapter
import com.example.Presentation.details.adapter.TeamInfoAdapter
import com.example.R
import com.example.databinding.FragmentCoinDetailsBinding
import com.example.model.DetailsTeamInfo
import com.example.model.TagsInfo
import com.example.model.tags
import com.example.model.teamMembers

class CoinDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCoinDetailsBinding

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
        setRecyclerViewTeamDetails(teamMembers)
        setRecyclerViewTagsInfoDetails(tags)
        setListeners()
        return binding.root

    }

    private fun setRecyclerViewTagsInfoDetails(tagsInfo: MutableList<TagsInfo>) {
        val recyclerTagsItemView = binding.recyclerViewTagsDetailsScreen
        val adapter = TagsInfoAdapter(tagsInfo)
        recyclerTagsItemView.adapter = adapter
    }

    private fun setRecyclerViewTeamDetails(teamInfo: MutableList<DetailsTeamInfo>) {
        val recyclerTeamItemView = binding.recyclerViewTeamDetails
        val adapter = TeamInfoAdapter(teamInfo)
        recyclerTeamItemView.adapter = adapter
        recyclerTeamItemView.layoutManager = LinearLayoutManager(context)
    }

    private fun setListeners() {
        binding.backButtonDetailsHomeScreen.setOnClickListener {
            findNavController().navigate(R.id.action_coinDetails_to_fragment_Home_Screen)
        }
    }
}

