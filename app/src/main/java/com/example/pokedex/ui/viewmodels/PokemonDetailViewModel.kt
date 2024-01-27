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
}