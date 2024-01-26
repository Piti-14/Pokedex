package com.example.pokedex.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  /*  @Provides
    @Singleton
    fun providePokemon(application: Application): PokemonDTO{
        val context = application.applicationContext
        val pokemon: PokemonDTO = getPokemonFromJSON("ditto.json", context)

        return pokemon
    }

    @Provides
    @Singleton
    fun providePokemonViewModel(application: Application, pokemonDTO: PokemonDTO): PokemonDetailViewModel{
        return PokemonDetailViewModel(application, pokemonDTO)
    }*/

}