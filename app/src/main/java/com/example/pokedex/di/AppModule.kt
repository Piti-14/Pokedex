package com.example.pokedex.di

import com.example.pokedex.data.sources.remote.PokemonApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit): PokemonApiService {
        return retrofit.create(PokemonApiService::class.java)
    }
}
