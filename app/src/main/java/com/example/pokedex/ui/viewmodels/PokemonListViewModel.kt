package com.example.pokedex.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val MAX_POKEMON = 2000
@HiltViewModel
class PokemonListViewModel @Inject constructor(private val useCase: GetPokemonListUseCase): ViewModel() {

    private var _pokemonList = MutableLiveData<PokemonList?>()
    val pokemonList: LiveData<PokemonList?> = _pokemonList

    private var cachedPokemonList = PokemonList(listOf())
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)


    init {
        viewModelScope.launch {
            _pokemonList.postValue(withContext(Dispatchers.IO){
                    useCase.getPokemonList(MAX_POKEMON)
                }
            )
        }
    }

    fun searchPokemon(query: String){
        val listToSearch = if (isSearchStarting){
            _pokemonList.value
        } else {
            cachedPokemonList
        }

        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()){
                _pokemonList.value = cachedPokemonList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }

            /*val results = listToSearch.{
                it.pokemonName.contains(query.trim(), ignoreCase = true) || it.number.toString() == query.trim()
            }*/

            if (isSearchStarting){
                cachedPokemonList = _pokemonList.value!!
                isSearchStarting = false
            }

            //_pokemonList.value = results
            isSearching.value = true
        }
    }
}