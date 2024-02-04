package com.example.pokedex.di

import android.app.Application
import com.example.pokedex.data.repositories.FallbackPokemonRepositoryImpl
import com.example.pokedex.data.repositories.LocalDataPokemonRepositoryImpl
import com.example.pokedex.data.repositories.RemoteDataPokemonRepositoryImpl
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.repositories.IPokemonRepository
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
    fun provideFallbackPokemonRepositoryImpl(
        localDataPokemonRepositoryImpl: LocalDataPokemonRepositoryImpl,
        remoteDataPokemonRepositoryImpl: RemoteDataPokemonRepositoryImpl
    ): IPokemonRepository{
        return FallbackPokemonRepositoryImpl(localDataPokemonRepositoryImpl, remoteDataPokemonRepositoryImpl)
    }

   /* @Provides
    @Singleton
    fun provideLocalDataPokemonRepository(pokemonLocalDataSource: PokemonLocalDataSource): IPokemonRepository{
        return LocalDataPokemonRepositoryImpl(pokemonLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataPokemonRepository(pokemonRemoteDataSource: PokemonRemoteDataSource): IPokemonRepository {
        return RemoteDataPokemonRepositoryImpl(pokemonRemoteDataSource)
    }*/
}