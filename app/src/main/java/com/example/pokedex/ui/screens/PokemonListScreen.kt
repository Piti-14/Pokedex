package com.example.pokedex.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.ui.viewmodels.PokemonListViewModel

@Composable
fun PokemonListScreen(
    listViewModel: PokemonListViewModel,
    detailViewModel: PokemonDetailViewModel,
    navController: NavHostController
) {

    val pokemons by listViewModel.pokemonList.observeAsState()

}