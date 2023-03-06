package com.example.tesla.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tesla.R
import com.example.tesla.Routes
import com.example.tesla.ui.theme.Purple200

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun congrats(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(
                    "Congrats",
                    color = Color.White)},
                backgroundColor = Color(0xff3700b3)
            ) },
        content = { congo(navController)}
    )
}

@Composable
fun congo(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Hurray!!! You did it.", style = TextStyle( fontSize = 50.sp, fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, color = Color.Magenta, shadow = Shadow(
            color = Color.Blue,
            blurRadius = 3f
        )
        ))
        Spacer(modifier = Modifier.height(10.dp))

        Image(painter = painterResource(id = R.drawable.congrats), contentDescription = "welcomerules", modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        val Context = LocalContext.current

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 40.dp)) {
            Button(

                onClick = {
                        navController.navigate(Routes.Login.route){
                            popUpTo("login")
                        }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Finish")
            }
        }

    }
}