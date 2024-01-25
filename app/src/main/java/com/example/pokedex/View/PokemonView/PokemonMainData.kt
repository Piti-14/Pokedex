package com.example.pokedex.View.PokemonView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel

@Composable
fun PokemonMainData(pokemon: PokemonDetailViewModel) {
    //val types = getPokemonTypes()
    /*LazyColumn(
        modifier = Modifier.fillMaxSize().padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        item{ Text(text = pokemon.name) }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(
                    text = pokemon.secondType,
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .background(color = Color.Blue, shape = CircleShape)
                        .padding(16.dp)
                        .clip(CircleShape)
                        .padding(8.dp)
                        .width(20.dp)
                        .height(20.dp)
                        .wrapContentSize(Alignment.Center)
                )
                *//*Card (Modifier.clip(CircleShape)){
                    Text(text = pokemon.firstType, textAlign = TextAlign.Center)
                }
                Text(text = pokemon.secondType, Modifier.background(Color.Black, CircleShape))*//*

                    *//*Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(color = Color.Blue, shape = CircleShape)
                            .clip(CircleShape)
                    ){
                        Text(
                            text = pokemon.secondType,
                            color = Color.White,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(8.dp)
                        )
                    }*//*
            }
        }
    }*/

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        pokemon.getPokemonName()

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                pokemon.getPokemonTypes()?.get(0)?.type?.let { Text(text = it.name) }
                Text(text = "${pokemon.pokemonWeight} KG")
                Text(text = "Weight")
            }

            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                pokemon.getPokemonTypes()?.get(1)?.type?.let { Text(text = it.name) }
                Text("${pokemon.getPokemonHeight()} m")
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
                Text(text = "HP")
                Text(text = "ATK")
                Text(text = "DEF")
                Text(text = "S-ATK")
                Text(text = "S-DEF")
                Text(text = "SPE")
                Text(text = "SPD")
                Text(text = "PRE")
                Text(text = "EVA")
            }

            Column(

            ) {
                Text(text = "HP")
                Text(text = "ATK")
                Text(text = "DEF")
                Text(text = "S-ATK")
                Text(text = "S-DEF")
                Text(text = "SPE")
                Text(text = "SPD")
                Text(text = "PRE")
                Text(text = "EVA")
            }
        }
    }
}



@Composable
fun PokemonStats(pokemon: PokemonDetailViewModel) {

    Card (){

    }
}