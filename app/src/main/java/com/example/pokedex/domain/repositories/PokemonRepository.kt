package com.example.pokedex.domain.repositories

import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.domain.models.PokemonDTO
import javax.inject.Inject


class PokemonRepository @Inject constructor(private val datasource: PokemonLocalDataSource){
  fun getPokemon(): PokemonDTO{
      return datasource.getPokemonFromJSON("ditto.json")
  }
}