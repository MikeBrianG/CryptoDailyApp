package com.example.model

data class DetailsTeamInfo(
    val nameTeam: String,
    val functionName: String,

    )

var teamMembers: MutableList<DetailsTeamInfo> = mutableListOf(
    DetailsTeamInfo(nameTeam = "Jhon max", "CEO"),
    DetailsTeamInfo(nameTeam = "Don Cliver", "MANAGER"),
    DetailsTeamInfo(nameTeam = "Tems Williams", "MANAGER"),
    DetailsTeamInfo(nameTeam = "Bryan Oliv", "FOUNDER"),
    DetailsTeamInfo(nameTeam = "Jhon max", "CEO"),
    DetailsTeamInfo(nameTeam = "Don Cliver", "MANAGER"),
    DetailsTeamInfo(nameTeam = "Tems Williams", "MANAGER"),
    DetailsTeamInfo(nameTeam = "Bryan Oliv", "FOUNDER"),
)