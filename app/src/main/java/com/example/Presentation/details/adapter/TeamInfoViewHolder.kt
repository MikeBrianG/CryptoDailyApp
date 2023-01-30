package com.example.Presentation.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.TeamDetailsScreenItemBinding
import com.example.model.DetailsTeamInfo

class TeamInfoViewHolder(private val binding: TeamDetailsScreenItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(detailsTeamInfo: DetailsTeamInfo) = with(binding) {

            textViewNameTeamDetailsScreen.text = detailsTeamInfo.nameTeam
            textViewFunctionTeamDetailScreen.text = detailsTeamInfo.functionName

        }
    companion object {
        fun create(parent: ViewGroup): TeamInfoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = TeamDetailsScreenItemBinding.inflate(inflater, parent, false)

            return TeamInfoViewHolder(binding)
        }
    }
}