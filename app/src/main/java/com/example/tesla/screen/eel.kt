package com.example.tesla.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tesla.R
import com.example.tesla.component.CustomTopAppBar

@Composable
fun eel(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBarEEL(navController as NavHostController)
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldWithTopBarEEL(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "EEL", true)
        }, content =
        {
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.eellogo),
                    contentDescription = "eel logo",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square

                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Electrical Engineers' Legation", style = TextStyle(
                        fontSize = 40.sp,
                        fontFamily = FontFamily.Cursive,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        shadow = Shadow(
                            color = Color.Green,
                            blurRadius = 4f
                        )
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp))

                Spacer(modifier = Modifier.height(20.dp))

                Card(shape = RoundedCornerShape(10.dp),border = BorderStroke(3.dp, Color.Blue), elevation = 30.dp,contentColor = Color.Red, modifier = Modifier.padding(15.dp)) {
                    Text(text = "The Electrical Engineers' Legation also abbreviated as EEL, is a student body that aims to foster and nurture young talent. The society organizes a plethora of events which includes both technical and non-technical events, thus giving the young and enthusiastic engineers an opportunity to unveil their talents!!",
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