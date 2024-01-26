package com.example.pokedex.data.sources.remote.DTOs

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)