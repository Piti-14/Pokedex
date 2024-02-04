package com.example.pokedex.data.repositories

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.IPokemonRepository
import javax.inject.Inject

class FallbackPokemonRepositoryImpl @Inject constructor(
    private val localPokemon: LocalDataPokemonRepositoryImpl,
    private val remotePokemon: RemoteDataPokemonRepositoryImpl): IPokemonRepository {
    override suspend fun getPokemon(pokemonName: String): Pokemon {
        return try {
            remotePokemon.getPokemon(pokemonName)
        } catch (e: Exception){
            localPokemon.getPokemon(pokemonName = pokemonName)
        }
    }

    override suspend fun getPokemonList(limit: Int): PokemonList {
        return try {
            remotePokemon.getPokemonList(limit)
        } catch (e: Exception){
            localPokemon.getPokemonList(limit)
        }
    }
}