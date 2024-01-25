package com.example.pokedex.di

import android.app.Application
import com.example.pokedex.domain.models.PokemonDTO
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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