package com.example.pokedex.mappers

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonListDTO
import com.example.pokedex.domain.models.Pokemon

class PokemonDataMapper {
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

        fun PokemonsFromDTOList(list: PokemonListDTO): List<String> {
            /*val pokemons = list.results.map { PokemonFromDTO(it) }
            list.results.get(0).
            return PokemonList(pokemons)*/
            val pokemonNameList = mutableListOf<String>()

            for (pokemon in list.results){
                 pokemonNameList.add(pokemon.name)
            }

            return pokemonNameList
        }
    }
}