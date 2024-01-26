package com.example.pokedex.mappers

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.domain.models.Pokemon

class PokemonDataMapper /*@Inject constructor (val pokemonDTO: PokemonDTO)*/ {
    companion object{
        fun PokemonFromDTO(pokemonDTO: PokemonDTO): Pokemon {
            val pokemon = Pokemon(
                pokemonDTO.name,
                pokemonDTO.height.toFloat(),
                pokemonDTO.weight.toFloat(),
                pokemonDTO.base_experience,
                pokemonDTO.id,
                pokemonDTO.sprites,
                pokemonDTO.stats,
                pokemonDTO.types
            )

            return pokemon
        }
    }
}