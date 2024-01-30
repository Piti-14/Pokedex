package com.example.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedex.data.sources.remote.DTOs.Stat
import com.example.pokedex.data.sources.remote.DTOs.Type
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.ui.theme.DetailBackground
import com.example.pokedex.ui.theme.PokeFontSolid
import com.example.pokedex.ui.theme.PokemonYellow
import com.example.pokedex.ui.theme.PrimaryPokedexColor
import com.example.pokedex.ui.theme.TypesColor

private const val MAX_STAT = 255
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailTopBar(id: Int, navController: NavController){

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = { navController.navigate("PokemonList_Screen") }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go Back",
                    tint = Color.White
                )
            }
        },
        title = {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 8.dp)
            ){
                Text(
                    text = "Pokedex",
                    fontFamily = PokeFontSolid,
                    color = PokemonYellow
                )
                Text(
                    text = "# $id",
                    fontFamily = PokeFontSolid,
                    color = PokemonYellow
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(DetailBackground)
    )
}

@Composable
fun PokemonDetailImageCard(pokemon: Pokemon) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(
                RoundedCornerShape(
                    bottomStart = 45.dp,
                    bottomEnd = 45.dp
                )
            ),
        colors = CardDefaults.cardColors(PrimaryPokedexColor)
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = pokemon.sprite.other.home.front_default,
                contentDescription = "PokeImage",
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .size(200.dp),
            )
        }
    }
}

@Composable
fun PokemonDetailName(name: String) {
    Text(
        text = name.uppercase(),
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White
    )
}

@Composable
fun PokemonDetailTypes(types: List<Type>) {
    var pokecolor = Color.White
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        types.forEach { pokemonType ->

            TypesColor.forEach {
                if (it.name == pokemonType.type.name){
                    pokecolor = it.color
                }
            }

            Row (
                horizontalArrangement = Arrangement.Center
            ){
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(pokecolor),
                ) {
                    Text(pokemonType.type.name)
                }
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
