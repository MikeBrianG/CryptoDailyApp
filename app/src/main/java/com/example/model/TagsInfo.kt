package com.example.model

data class TagsInfo(
    val nameTag: String,
    )

var tags: MutableList<TagsInfo> = mutableListOf(
   TagsInfo("TAG 1"),
   TagsInfo("TAG 2"),
   TagsInfo("TAG 3"),
   TagsInfo("TAG 4"),
   TagsInfo("TAG 5"),
   TagsInfo("TAG 6"),
)