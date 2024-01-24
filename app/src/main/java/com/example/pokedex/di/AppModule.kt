package com.example.pokedex.di

import android.app.Application
import com.example.pokedex.data.sources.local.getPokemonFromJSON
import com.example.pokedex.domain.models.PokemonDTO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

   /* @Provides
    @Singleton
    fun providePokemon(application: Application): PokemonDTO{
        //val pokemon: PokemonDTO = getPokemonFromJSON("ditto.json")
    }*/

}