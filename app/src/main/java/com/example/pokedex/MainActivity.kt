package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.pokedex.View.PokemonView.PokemonPage
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.viewModel.Pokemon
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {

                val pokemon_detailViewModel: PokemonDetailViewModel by viewModels<PokemonDetailViewModel>()

                val ditto = Pokemon(132, "Ditto","Normal", "Plant", 40.0, 3.0,R.drawable.ditto)
                PokemonPage(pokemon_detailViewModel)
                //PokemonList()
            }
        }
    }
}