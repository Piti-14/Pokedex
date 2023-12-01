package com.example.pokedex.View

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.viewModel.Pokemon

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonPage(pokemon: Pokemon) {
    Scaffold (
        topBar = { PokemonTopBar(pokemon.id) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ){
            PokemonMainCard(pokemon.image)
            //PokemonMainData()
            //PokemonStats()
        }    
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTopBar(id: Int) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        title = {
            Row (
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Text(text = "Pokedex")
                Text(text = "#${id}")
            }
        }
    )
}

@Composable
fun PokemonMainCard(image: Int) {

    Card (
        modifier = Modifier.fillMaxWidth().height(225.dp),
        shape = RoundedCornerShape(25)
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            alignment = BottomCenter,
            modifier = Modifier.fillMaxWidth()
            //contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun PokemonMainData() {
    //val types = getPokemonTypes()
    LazyColumn(){

    }
    
}



@Composable
fun PokemonStats() {

    /*Card (){
        Image(painter = painterResource(id = 1), contentDescription = "")
    }*/
}