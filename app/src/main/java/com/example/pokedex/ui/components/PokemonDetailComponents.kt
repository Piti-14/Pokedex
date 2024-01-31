package com.example.pokedex.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedex.R
import com.example.pokedex.data.sources.remote.DTOs.Stat
import com.example.pokedex.data.sources.remote.DTOs.Type
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.ui.theme.PokeFontSolid
import com.example.pokedex.ui.theme.PokemonYellow
import com.example.pokedex.ui.theme.PrimaryPokedexColor
import com.example.pokedex.ui.theme.TypesColor
import com.example.pokedex.util.parseStatToAbreviation
import com.example.pokedex.util.parseStatToColor

private const val MAX_STAT = 255

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailTopBar(id: Int, navController: NavController) {

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go Back",
                    tint = Color.White
                )
            }
        },
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = "Pokedex",
                    fontFamily = PokeFontSolid,
                    color = PokemonYellow,
                    letterSpacing = 6.sp
                )
                Text(
                    text = "# $id",
                    fontFamily = PokeFontSolid,
                    color = PokemonYellow
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(PrimaryPokedexColor)
    )
}

@Composable
fun PokemonDetailImageCard(pokemon: Pokemon) {
    Card(
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
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = pokemon.sprite.other.home.front_default,
                contentDescription = "PokeImage",
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .size(200.dp),
                contentScale = ContentScale.FillHeight
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        types.forEach { pokemonType ->

            TypesColor.forEach {
                if (it.name == pokemonType.type.name) {
                    pokecolor = it.color
                }
            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(CircleShape)
                    .background(pokecolor)
                    .weight(1f)
                    .height(35.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    pokemonType.type.name.replaceFirstChar { it.uppercase() },
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }

}

@Composable
fun PokemonDetailMeasures(height: Float, weight: Float) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.height),
                tint = Color.Black,
                contentDescription = "Weight"
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "${height / 10} m",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(
            modifier = Modifier
                .size(5.dp, 85.dp)
                .background(Color.Black)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.weight),
                tint = Color.Black,
                contentDescription = "Height"
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "${weight / 10} Kg",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Composable
fun PokemonDetailStats(animDelayPerItem: Int = 100, stats: List<Stat>) {

    val maxBaseStat by rememberSaveable { mutableStateOf(stats.maxOf { it.base_stat }) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                "Base Stats",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        stats.forEach { pokemonStat ->
            var index = 0
            PokemonStat(
                statName = parseStatToAbreviation(pokemonStat),
                statValue = pokemonStat.base_stat,
                statColor = parseStatToColor(pokemonStat),
                animDelay = index * animDelayPerItem,
                statMaxValue = maxBaseStat
            )
            index++
        }
    }
}

@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    animDuration: Int = 1500,
    animDelay: Int = 0
) {
    var animationPlayed by rememberSaveable { mutableStateOf(false) }

    val currentPercent = animateFloatAsState(
        targetValue = (if (animationPlayed) statValue / statMaxValue.toFloat() else 0f),
        label = "",
        animationSpec = tween(animDuration, animDelay)
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .clip(CircleShape)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(currentPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp),
        ) {
            Text(text = statName, fontWeight = FontWeight.Bold)
            Text(
                text = "${(currentPercent.value * statMaxValue).toInt()} / $MAX_STAT",
                fontWeight = FontWeight.Bold
            )
            //Text(text = statMaxValue.toString(), fontWeight = FontWeight.Bold)
        }
    }
}
