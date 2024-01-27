package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.pokedex.domain.models.Pokemon

@Composable
fun PokemonListItem(pokemon: Pokemon) {
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
                painter = painterResource(id = R.drawable.ditto),
                contentDescription = pokemon.name,
                modifier = Modifier.padding( end = 100.dp),
                contentScale = ContentScale.Crop
            )

            Text(text = "${pokemon.name} \t#${pokemon.id}")
        }
    }
}