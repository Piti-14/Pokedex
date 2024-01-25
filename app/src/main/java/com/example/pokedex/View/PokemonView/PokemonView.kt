package com.example.pokedex.View.PokemonView

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonPage(detailViewModel: PokemonDetailViewModel) {
    Scaffold (
        topBar = { PokemonTopBar(detailViewModel.getPokemonID()) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
                //.padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            PokemonMainCard(detailViewModel)
            PokemonMainData(detailViewModel)
            PokemonStats(detailViewModel)
        }    
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTopBar(id: Int?) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        title = {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = CenterVertically,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = "Pokédex")
                Text(text = "#${id}")
            }
        }
    )
}