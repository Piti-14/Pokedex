package com.example.pokedex.domain.models

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)