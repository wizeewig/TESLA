package com.example.tesla.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tesla.component.CustomTopAppBar

@Composable
fun tesla(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBarTesla(navController as NavHostController)
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldWithTopBarTesla(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "TESLA", true)
        }, content =
        {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "TESLA", style = TextStyle(
                fontSize = 70.sp,
                fontFamily = FontFamily.Cursive,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                shadow = Shadow(
                    color = Color.Red,
                    blurRadius = 4f
                )
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Card(shape = RoundedCornerShape(10.dp),border = BorderStroke(3.dp, Color.Blue), elevation = 30.dp,contentColor = Color.Red, modifier = Modifier.padding(15.dp)) {
            Text(text = "'If you prepare the roots, You don’t need to repair the fruits!’ Ever thrilled by the heroes furiously decoding secret codes leading to the fall of enemies? You think you too are smart enough to do the same. 'Tesla' an online treasure hunt event which requires some technical expertise in encryption, encoding ( or decryption , decoding, likewise) to crack the levels, a little bit of general knowledge, and a humongous amount of common sense other than web search.",
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    shadow = Shadow(
                        color = Color.Blue,
                        blurRadius = 2f
                    )
                )
            )
        }

    }

        })
}