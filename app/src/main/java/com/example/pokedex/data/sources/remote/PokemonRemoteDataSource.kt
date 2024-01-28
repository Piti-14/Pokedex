package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonListDTO
import com.google.gson.Gson
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(private val pokemonApi: PokemonApiService){
    //IMPLEMENTAR:  construir de las llamadas de api a pokemonDTO y listPokemonDTO

    private val gson = Gson()
    suspend fun getListPokemonDTO(limit: Int): PokemonListDTO{
        //convertir lo que llega de la api a lista PokemonDTO

        val jsonList = pokemonApi.getPokemonList(limit)
        return gson.fromJson(jsonList, PokemonListDTO::class.java)
    }

    suspend fun getPokemonDTO(pokemonName: String): PokemonDTO{
        //convertir lo que llega de la api a PokemonDTO

        val jsonPokemon = pokemonApi.getPokemonDetail(pokemonName)
        return gson.fromJson(jsonPokemon.reader(), PokemonDTO::class.java)
    }
}