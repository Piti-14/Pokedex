package com.example.pokedex.data.sources.local

import android.app.Application
import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonListDTO
import com.google.gson.Gson
import java.io.InputStream
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor (private val application: Application) {

    fun getPokemonList(): PokemonListDTO {
        val pokemonList = accessJSONFromAssets("pokemons.json")

        return PokemonDTOListToModel(pokemonList)
    }

    fun getPokemonFromJSON(filename: String): PokemonDTO {
        val pokemonJSON = accessJSONFromAssets("ditto.json")

        return PokemonDTOToModel(pokemonJSON)
    }

    private fun accessJSONFromAssets(json: String): InputStream {
        //Accedemos al JSON
        return application.assets.open(json)
    }

    private fun PokemonDTOToModel(jsonObject: InputStream): PokemonDTO {
        //GSON convierte el json a PokemonDTO
        val gson = Gson()
        val reader = jsonObject.reader()

        val pokemon: PokemonDTO = gson.fromJson(reader, PokemonDTO::class.java)

        reader.close()
        return pokemon
    }

    private fun PokemonDTOListToModel(jsonObject: InputStream): PokemonListDTO {
        //GSON convierte el json a PokemonListDTO
        val gson = Gson()
        val reader = jsonObject.reader()

        val pokemonList: PokemonListDTO = gson.fromJson(reader, PokemonListDTO::class.java)

        reader.close()
        return pokemonList
    }
}