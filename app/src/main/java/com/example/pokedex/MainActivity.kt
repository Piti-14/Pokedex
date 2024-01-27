package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.screens.LandingPageScreen
import com.example.pokedex.ui.screens.PokemonDetailScreen
import com.example.pokedex.ui.screens.PokemonListScreen
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {

                val pokemonListViewModel: PokemonListViewModel = hiltViewModel()
                val pokemonDetailViewModel: PokemonDetailViewModel = hiltViewModel()
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "PokemonDetail_Screen"){
                    composable("PokemonList_Screen"){
                        PokemonListScreen(pokemonListViewModel, pokemonDetailViewModel, navController) }

                    composable("PokemonDetail_Screen"){
                        PokemonDetailScreen( pokemonDetailViewModel, navController )
                    }

                    composable("LandingPage_Screen"){ LandingPageScreen(navController) }
                }
                //PokemonPage(pokemon_detailViewModel)
                //PokemonList()
            }
        }
    }
}