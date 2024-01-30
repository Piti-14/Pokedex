package com.example.pokedex.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.R
import com.example.pokedex.ui.components.PokemonListItem
import com.example.pokedex.ui.theme.PrimaryPokedexColor
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.ui.viewmodels.PokemonListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonListScreen(
    listViewModel: PokemonListViewModel,
    detailViewModel: PokemonDetailViewModel,
    navController: NavHostController
) {

    val pokemons by listViewModel.pokemonList.observeAsState()

    if (pokemons != null) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryPokedexColor)
        ) {

            stickyHeader {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            shape = RoundedCornerShape(
                                bottomStart = 45.dp,
                                bottomEnd = 45.dp
                            )
                        ),
                    colors = CardDefaults.cardColors(PrimaryPokedexColor)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokedex_logo),
                        contentDescription = "Pokedex Logo",
                        Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            items(pokemons?.pokemons!!.size) {
                PokemonListItem(id = (it + 1), name = pokemons!!.pokemons[it], detailViewModel, navController)
            }
        }
    } else {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Loading...")
            CircularProgressIndicator()
        }
    }
}