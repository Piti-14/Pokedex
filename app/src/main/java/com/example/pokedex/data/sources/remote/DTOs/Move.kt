package com.example.pokedex.data.sources.remote.DTOs

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)