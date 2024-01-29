package com.example.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel

@Composable
fun PokemonListItem(
    id: Int,
    name: String,
    viewModel: PokemonDetailViewModel,
    navController: NavHostController
) {
    Card(
        shape = RoundedCornerShape(18),
        elevation = CardDefaults.cardElevation(12.dp),
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
            .clickable {
                viewModel.initializePokemon(name)
                navController.navigate("PokemonDetail_Screen")
            }
    ) {
        Row (
            Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                text = "$name".replaceFirstChar { it.uppercase() },
                modifier = Modifier.padding(start = 12.dp)
            )
            Text(
                text = "#$id",
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}