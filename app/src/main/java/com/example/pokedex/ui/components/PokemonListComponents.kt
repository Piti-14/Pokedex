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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex.ui.theme.DarkGrey
import com.example.pokedex.ui.theme.LightGrey
import com.example.pokedex.ui.theme.PokeFontHollow
import com.example.pokedex.ui.theme.PokeFontSolid
import com.example.pokedex.ui.theme.Purple80
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
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
            },
        colors = CardDefaults.cardColors(Purple80)
    ) {
        Row (
            Modifier
                .fillMaxSize()
                .background(DarkGrey)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                text = "$name".replaceFirstChar { it.uppercase() },
                modifier = Modifier.padding(start = 10.dp),
                fontFamily = PokeFontHollow,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp ,
                color = Color.Yellow,
                letterSpacing = 2.sp,

            )

            Text(
                text = "# $id",
                modifier = Modifier.padding(end = 10.dp),
                fontFamily = PokeFontSolid,
                fontSize = 18.sp,
                color = LightGrey
            )
        }
    }
}