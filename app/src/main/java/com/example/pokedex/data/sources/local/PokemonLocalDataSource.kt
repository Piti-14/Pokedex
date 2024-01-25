package com.example.pokedex.data.sources.local

import android.app.Application
import android.content.Context
import com.example.pokedex.domain.models.PokemonDTO
import com.google.gson.Gson
import java.io.InputStream
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor (private val application: Application) {

    fun getPokemonFromJSON(filename: String): PokemonDTO {
        val pokemonJSON = accessJSONFromAssets(filename)
        val pokemon = JSONtoModel(pokemonJSON)

        return pokemon
    }

    fun accessJSONFromAssets(json: String): InputStream {
        //Accedemos al JSON
        return application.assets.open(json)
    }

    fun JSONtoModel(jsonObject: InputStream): PokemonDTO {
        //GSON convierte el json a Pokemon
        val gson = Gson()
        val reader = jsonObject.reader()

        val pokemon: PokemonDTO = gson.fromJson(reader, PokemonDTO::class.java)

        reader.close()
        return pokemon
    }
}