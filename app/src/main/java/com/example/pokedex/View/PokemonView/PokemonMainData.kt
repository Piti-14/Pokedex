package com.example.pokedex.View.PokemonView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.viewModel.Pokemon

@Composable
fun PokemonMainData(pokemon: Pokemon) {
    //val types = getPokemonTypes()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item{ Text(text = pokemon.name) }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Card (Modifier.width(90.dp)){
                    Text(text = pokemon.firstType)
                }
                Text(text = pokemon.secondType)
            }
        }
    }
}



@Composable
fun PokemonStats(pokemon: Pokemon) {

    /*Card (){
        Image(painter = painterResource(id = 1), contentDescription = "")
    }*/
}