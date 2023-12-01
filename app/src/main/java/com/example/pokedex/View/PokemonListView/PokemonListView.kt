package com.example.pokedex.View.PokemonListView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.viewModel.Pokemon


@Composable
fun PokemonList() {
    val ditto = Pokemon(132, "Ditto","Normal", "Plant", 40.0, 3.0,R.drawable.ditto)
    val pokemons = listOf<Pokemon>( ditto, ditto, ditto, ditto, ditto, ditto, ditto, ditto, ditto )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(start = 10.dp, end = 10.dp)
    ){
        items(pokemons.size){
            PokemonListCard(pokemons[it])
        }
    }
}

@Composable
fun PokemonListCard(pokemon: Pokemon) {
    Card(
        shape = RoundedCornerShape(18),
        elevation = CardDefaults.cardElevation(12.dp),
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            //.padding(8.dp)
    ) {
        Row (
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.padding( end = 100.dp),
                contentScale = ContentScale.Crop
            )

            Text(text = "${pokemon.name} \t#${pokemon.id}")
        }
    }
}
