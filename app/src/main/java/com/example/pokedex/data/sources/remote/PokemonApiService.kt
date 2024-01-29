package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): PokemonListDTO


    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDTO
}