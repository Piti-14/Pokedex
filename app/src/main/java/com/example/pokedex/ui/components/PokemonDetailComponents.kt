package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedex.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailTopBar(id: Int?, navController: NavController){

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navController.navigate("PokemonList_Screen") }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go Back")
            }
        },
        title = {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = "Pokedex")
                Text(text = "#${id}")
            }
        }
    )
}

@Composable
fun PokemonDetailImageCard(){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(25)
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.ditto),
                contentDescription = "Pokemon_img",
                alignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Inside
            )
        }
    }
}

@Composable
fun PokemonDetailName(){}

@Composable
fun PokemonDetailTypes(){}

@Composable
fun PokemonDetailMeasures(){}

@Composable
fun PokemonDetailStats(){}