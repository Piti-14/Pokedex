package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pokedex.View.PokemonView.PokemonPage
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.viewModel.Pokemon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val ditto = Pokemon(132, "Ditto","Normal", "Plant", 40.0, 3.0,R.drawable.ditto)
                PokemonPage(pokemon = ditto)
                //PokemonList()
            }
        }
    }
}