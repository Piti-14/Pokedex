package com.example.pokedex.data.sources.local

import android.content.Context
import com.example.pokedex.domain.models.PokemonDTO
import com.google.gson.Gson
import java.io.InputStream

fun getPokemonFromJSON(filename: String, context: Context): PokemonDTO{
    val pokemonJSON = accessJSONFromAssets(filename, context)
    val pokemon = JSONtoModel(pokemonJSON)

    return pokemon
}
fun accessJSONFromAssets(json: String, context: Context): InputStream {
    //Accedemos al JSON
    return context.assets.open(json)
}

fun JSONtoModel(jsonObject: InputStream): PokemonDTO{
    //GSON convierte el json a Pokemon
    val gson = Gson()
    val reader = jsonObject.reader()

    val pokemon: PokemonDTO = gson.fromJson(reader, PokemonDTO::class.java)

    reader.close()
    return pokemon
}