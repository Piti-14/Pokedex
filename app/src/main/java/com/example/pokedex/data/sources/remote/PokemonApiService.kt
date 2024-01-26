package com.example.pokedex.data.sources.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") linit: Int): String

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): String
}