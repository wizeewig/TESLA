package com.example.tesla.screen

import android.media.Image
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.tesla.R
import com.example.tesla.Routes
import kotlinx.coroutines.delay

@Composable
fun splashscreen(navController: NavController){

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        // Customize the delay time
        delay(3000L)
        navController.navigate(Routes.Login.route){
            popUpTo(0)
        }
    }

    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.splashscreenbg), contentDescription = "splashBGimg",
        contentScale = ContentScale.FillBounds,
    )

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.splash_screen),
            contentDescription = "splash", modifier = Modifier.scale(scale.value))
    }
}