package com.example.pokedex.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pokedex.ui.components.PokemonDetailImageCard
import com.example.pokedex.ui.components.PokemonDetailMeasures
import com.example.pokedex.ui.components.PokemonDetailName
import com.example.pokedex.ui.components.PokemonDetailStats
import com.example.pokedex.ui.components.PokemonDetailTopBar
import com.example.pokedex.ui.components.PokemonDetailTypes
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonDetailScreen(pokemonDetailViewModel: PokemonDetailViewModel, navController: NavController){

    val pokemon by pokemonDetailViewModel.pokemon.observeAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { PokemonDetailTopBar(pokemon?.id) }
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            PokemonDetailImageCard()//COIL mirar COIL

            PokemonDetailName()
            PokemonDetailTypes()
            PokemonDetailMeasures()

            PokemonDetailStats()
        }
    }
}