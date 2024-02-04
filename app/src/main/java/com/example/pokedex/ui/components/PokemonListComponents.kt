package com.example.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex.ui.theme.DarkGrey
import com.example.pokedex.ui.theme.LightGrey
import com.example.pokedex.ui.theme.PokeFontSolid
import com.example.pokedex.ui.theme.PokemonYellow
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
                fontFamily = PokeFontSolid,
                fontWeight = FontWeight.Thin,
                fontSize = 20.sp ,
                color = PokemonYellow,
                letterSpacing = 3.sp,

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


@Composable
fun PokemonSearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
){
    var searchText by rememberSaveable { mutableStateOf("") }
    var isHintDisplayed by rememberSaveable { mutableStateOf(hint != "") }

    Box(modifier = modifier){

        BasicTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearch(it)
            },
            singleLine = true,
            textStyle = TextStyle(Color.Black),
            modifier = Modifier
                    .fillMaxWidth()
                .shadow(8.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .onFocusChanged { isHintDisplayed = !it.isFocused }
        )

        if (isHintDisplayed){
            Text(
                text = hint,
                color = LightGrey,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
            )
        }
    }
}
