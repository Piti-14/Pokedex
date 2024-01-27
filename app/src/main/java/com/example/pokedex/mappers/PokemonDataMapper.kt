package com.example.pokedex.mappers

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonDTOList
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList

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

        fun PokemonsFromDTOList(list: PokemonDTOList): PokemonList{
            val pokemons = list.pokemons.map { PokemonFromDTO(it) }
            return PokemonList(pokemons)
        }
    }
}