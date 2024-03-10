package com.zorbeytorunoglu.cookieclicker.feature.game

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen() {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Cookie()

    }

}

@Composable
fun Cookie() {

    var isBouncing by remember { mutableStateOf(false) }
    val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isBouncing) 1.2f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 250, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "bounceAnimation"
    )

    Image(
        painter = painterResource(id = com.zorbeytorunoglu.cookieclicker.core.ui.R.drawable.cookie),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .scale(scale)
            .clickable {
                isBouncing = !isBouncing
                Log.d("GameScreen", "Clicked")
            }
    )

}