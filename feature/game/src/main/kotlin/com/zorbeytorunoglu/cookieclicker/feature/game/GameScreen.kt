package com.zorbeytorunoglu.cookieclicker.feature.game

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun GameScreen() {

    Column(
        Modifier.fillMaxSize()
    ) {

        CookieClickerAnimation()

    }

}

@Composable
fun CookieClickerAnimation() {

    val density = LocalDensity.current
    var visible by remember { mutableStateOf(false) }
    var tapPosition by remember { mutableStateOf(IntOffset.Zero) }

    // Animate the vertical position (floating up)
    val offsetY by animateDpAsState(
        targetValue = if (visible) (-120).dp else 0.dp,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = ""
    )

    LaunchedEffect(key1 = visible) {
        delay(1000)
        visible = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    tapPosition = offset.round()
                    visible = true
                }
            },
        contentAlignment = Alignment.Center
    ) {
        // Show the "+1" text with animation
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn() + slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)
            ),
            exit = fadeOut() + slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
            )
        ) {
            Text(
                text = "+1",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                modifier = Modifier
                    .offset(
                        x = with(density) { tapPosition.x.toDp() },
                        y = offsetY
                    )
            )
        }
    }
}

@Composable
fun Cookie() {

    var isBouncing by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isBouncing) 1.2f else 1f,
        animationSpec = tween(durationMillis = 75, easing = FastOutSlowInEasing),
        finishedListener = {
            isBouncing = false
        },
        label = "cookieInOutAnimation"
    )

    Image(
        painter = painterResource(id = com.zorbeytorunoglu.cookieclicker.core.ui.R.drawable.cookie),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .scale(scale)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                isBouncing = true
                Log.d("GameScreen", "Clicked")
            }
    )

}