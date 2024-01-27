package com.example.pokedex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.ui.components.PokemonListItem
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.ui.viewmodels.PokemonListViewModel

@Composable
fun PokemonListScreen(
    listViewModel: PokemonListViewModel,
    detailViewModel: PokemonDetailViewModel,
    navController: NavHostController
) {

    val pokemons by listViewModel.pokemonList.observeAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp)
    ){
        pokemons?.pokemons?.let { it ->
            items(it.size){
                PokemonListItem(pokemons!!.pokemons[it])
            }
        }
    }
}