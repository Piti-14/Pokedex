package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel
    @Inject constructor(private val useCase: GetPokemonDetailUseCase): ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun initializePokemon(filename: String){
        viewModelScope.launch {
            _pokemon.postValue(withContext(Dispatchers.IO){
                useCase.getPokemonDetail(filename)
            })
        }
    }


    /*private var _pokemonName = MutableLiveData<String>()
    val pokemonName: LiveData<String> = _pokemonName

    private var _pokemonHeight = MutableLiveData<Int>()
    val pokemonHeight: LiveData<Int> = _pokemonHeight

    private var _pokemonWeight = MutableLiveData<Int>()
    val pokemonWeight: LiveData<Int> = _pokemonWeight

    private var _pokemonID = MutableLiveData<Int>()
    val pokemonID: LiveData<Int> = _pokemonID

    private var _pokemonTypes = MutableLiveData<List<Type>>()
    val pokemonTypes: LiveData<List<Type>> = _pokemonTypes

    private var _pokemonStats = MutableLiveData<List<Stat>>()
    val pokemonStats: LiveData<List<Stat>> = _pokemonStats

    private var _pokemonExp = MutableLiveData<Int>()
    val pokemonExp: LiveData<Int> = _pokemonExp

    private var _pokemonSprite = MutableLiveData<Sprites>()
    val pokemonSprite: LiveData<Sprites> = _pokemonSprite

    init {
        _pokemonName.value = pokemon.name
        _pokemonHeight.value = pokemon.height
        _pokemonWeight.value = pokemon.weight
        _pokemonID.value = pokemon.id
        _pokemonTypes.value = pokemon.types
        _pokemonStats.value = pokemon.stats
        _pokemonExp.value = pokemon.base_experience
        _pokemonSprite.value = pokemon.sprites
    }

    fun getPokemonName(): String? {
        return pokemonName.value
    }

    fun getPokemonHeight(): Int? {
        return pokemonHeight.value
    }

    fun getPokemonWeight(): Int? {
        return pokemonWeight.value
    }

    fun getPokemonID(): Int? {
        return pokemonID.value
    }

    fun getPokemonTypes(): List<Type>? {
        return pokemonTypes.value
    }

    fun getPokemonStats(): List<Stat>? {
        return pokemonStats.value
    }

    fun getPokemonExp(): Int? {
        return pokemonExp.value
    }

    fun getPokemonSprite(): Sprites? {
        return pokemonSprite.value
    }*/
}