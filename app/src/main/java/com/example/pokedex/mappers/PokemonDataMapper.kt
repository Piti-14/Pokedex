package com.example.pokedex.mappers

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonDTOList
import com.example.pokedex.data.sources.remote.DTOs.PokemonListDTO
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import javax.inject.Inject

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

        fun PokemonsFromDTOList(list: PokemonListDTO): PokemonList{
            /*val pokemons = list.results.map { PokemonFromDTO(it) }
            list.results.get(0).
            return PokemonList(pokemons)*/

            for (pokemon in list.results){
                 pokemon.name
            }
        }
    }
}