package com.example.pokedex.View

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.viewModel.Pokemon

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonPage(pokemon: Pokemon) {
    Scaffold (
        topBar = { PokemonTopBar() }
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            PokemonMainCard()
            PokemonMainData()
            PokemonStats()
        }    
    }
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTopBar() {
    TopAppBar(
        navigationIcon = {},
        title = { "Pokedex" },
    )
}

@Composable
fun PokemonMainCard() {

}

@Composable
fun PokemonMainData() {
    /*//val types = getPokemonTypes()
    LazyColumn() {
        Text(text = "Pokemon")

        LazyRow() {
            items(types.size) {
                //type
            }
        }
    }*/
    
}



@Composable
fun PokemonStats() {

    /*Card (){
        Image(painter = painterResource(id = 1), contentDescription = "")
    }*/
}