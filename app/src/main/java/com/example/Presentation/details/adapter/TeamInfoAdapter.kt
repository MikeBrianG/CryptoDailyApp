package com.example.Presentation.details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.DetailsTeamInfo

class TeamInfoAdapter(private val coinTeamInfo: MutableList<DetailsTeamInfo>) :
    RecyclerView.Adapter<TeamInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamInfoViewHolder {

        return TeamInfoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TeamInfoViewHolder, position: Int) {
        val teamMember = coinTeamInfo[position]
        holder.bind(teamMember)
    }

    override fun getItemCount(): Int = coinTeamInfo.size

}