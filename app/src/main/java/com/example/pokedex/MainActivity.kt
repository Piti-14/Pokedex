package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedex.View.PokemonList
import com.example.pokedex.View.PokemonPage
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.viewModel.Pokemon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val ditto = Pokemon(132, "Ditto", 6,"Normal", "Plant", 40.0, 3.0,R.drawable.ditto)
                PokemonPage(pokemon = ditto)
                //PokemonList()
            }
        }
    }
}