package com.example.pokedex.View.PokemonView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PokemonMainCard(image: Int) {

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(25)
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentScale = ContentScale.Inside
        )
    }
}