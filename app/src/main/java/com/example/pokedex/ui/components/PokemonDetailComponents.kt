package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.pokedex.data.sources.remote.DTOs.Stat
import com.example.pokedex.data.sources.remote.DTOs.Type

private const val MAX_STAT = 255
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailTopBar(id: Int, navController: NavController){

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
fun PokemonDetailName(name: String) {
    Text(text = name.uppercase())
}

@Composable
fun PokemonDetailTypes(types: List<Type>) {

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        types.forEach { type ->
            Row {
                Text(type.type.name)
            }
        }
    }

}

@Composable
fun PokemonDetailMeasures(height: Float, weight: Float) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Row { Text("$height m")}
        Row { Text("$weight Kg")}
    }
}

@Composable
fun PokemonDetailStats(stats: List<Stat>) {

    Text("Base Stats")
    Row (
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ){
        Column{
            stats.forEach{ stat ->
                Text("${stat.stat.name.uppercase()}:  ${stat.base_stat} / $MAX_STAT")
            }
        }
    }
}
