package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonDTOList
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(val pokemonApi: PokemonApiService){
    //IMPLEMENTAR construir de las llamadas de api a pokemonDTO y listPokemonDTO

    suspend fun getListPokemonDTO(): PokemonDTOList{
        //convertir lo que llega de la api a lista PokemonDTO
        return pokemonApi.getPokemonList(2000)
    }

    suspend fun getPokemonDTO(): PokemonDTO{
        //convertir lo que llega de la api a PokemonDTO
        return pokemonApi.getPokemonDetail("charmander")
    }
}