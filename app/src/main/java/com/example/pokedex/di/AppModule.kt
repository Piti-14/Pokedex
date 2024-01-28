package com.example.pokedex.di

import android.app.Application
import com.example.pokedex.data.repositories.PokemonDetailRepositoryImpl
import com.example.pokedex.data.repositories.PokemonListRepositoryImpl
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.repositories.PokemonDetailRepository
import com.example.pokedex.domain.repositories.PokemonListRepository
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

    @Provides
    @Singleton
    fun providePokemonAPIService(): PokemonApiService {
        return Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()

            .create(PokemonApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(application: Application): PokemonLocalDataSource{
        return PokemonLocalDataSource(application)
    }

    @Provides
    @Singleton
    fun providePokemonRemoteDataSource(pokemonApiService: PokemonApiService): PokemonRemoteDataSource {
        return PokemonRemoteDataSource(pokemonApiService)
    }

    @Provides
    @Singleton
    fun providePokemonDetailRepository(pokemonLocalDataSource: PokemonLocalDataSource): PokemonDetailRepository{
        return PokemonDetailRepositoryImpl(pokemonLocalDataSource)
    }

    @Provides
    @Singleton
    fun providePokemonListRepository(pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonListRepository {
        return PokemonListRepositoryImpl(pokemonRemoteDataSource)
    }
}