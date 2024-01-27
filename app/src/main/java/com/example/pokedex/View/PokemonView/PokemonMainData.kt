package com.example.pokedex.View.PokemonView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel

@Composable
fun PokemonMainData(pokemonViewModel: PokemonDetailViewModel) {

    pokemonViewModel.initializePokemon("ditto.json")//habría que llamarlo en la pantalla de PokemonList
    val pokemon: Pokemon? by pokemonViewModel.pokemon.observeAsState()

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "${pokemon?.name}")

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Text("${pokemon?.types?.get(0)?.type?.name}")
                Text(text = "${pokemon?.weight} KG")
                //Text(text = "pep KG")
                Text(text = "Weight")
            }

            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
               // pokemon.getPokemonTypes()?.get(1)?.type?.let { Text(text = it.name) }
                Text("${pokemon?.height} m")
                Text(text = "Height")
            }
        }

        Text("Base Stats")

        Row (
            horizontalArrangement = Arrangement.spacedBy(40.dp)
                //modifier = Modifier.fillMaxWidth()
        ){
            Column(

            ) {
                pokemon?.stats?.forEach { stat ->
                    Text(text = "${stat.stat.name.uppercase()}: ${stat.base_stat} / 255")
                }
            }
        }
    }
}



@Composable
fun PokemonStats(pokemon: PokemonDetailViewModel) {

    Card (){

    }
}