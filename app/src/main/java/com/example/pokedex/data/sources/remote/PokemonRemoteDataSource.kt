package com.example.pokedex.data.sources.remote

import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(val pokemonApi: PokemonApiService){
    //IMPLEMENTAR construir de las llamadas de api a pokemonDTO y listPokemonDTO

    fun getListPokemonDTO(){
        //convertir lo que llega de la api a lista PokemonDTO
    }

    fun getPokemonDTO(){
        //convertir lo que llega de la api a PokemonDTO

    }
}