package com.example.tesla.screen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tesla.R
import com.example.tesla.Routes


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Rules(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(
                    "RULES",
                    color = Color.White)},
                backgroundColor = Color(10,10,41)
            ) },
        content = { MyRules(navController)}
    )
    }

@Composable
fun MyRules(navController: NavController){

    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.rulesbg), contentDescription = "img",
        contentScale = ContentScale.FillBounds,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(painter = painterResource(id = R.drawable.welcome), contentDescription = "welcomerules", modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))

        val checkedState = remember { mutableStateOf(false) }
        Row(horizontalArrangement = Arrangement.Start,) {
            Checkbox(
                // below line we are setting
                // the state of checkbox.
                checked = checkedState.value,
                // below line is use to add padding
                // to our checkbox.
                modifier = Modifier.padding(20.dp).size(3.dp),
                // below line is use to add on check
                // change to our checkbox.
                onCheckedChange = { checkedState.value = it },
                enabled = true,
                colors = CheckboxDefaults.colors(checkedColor= Color.Black, uncheckedColor = Color.White, checkmarkColor = Color.White),

            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = "Yes, I have read the rules.", modifier = Modifier.padding(12.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.White)
        }

        Spacer(modifier = Modifier.height(25.dp))

        val Context = LocalContext.current
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 40.dp)) {
            Button(
                onClick = {
                    if(checkedState.value) {
                        navController.navigate(Routes.level1.route){
                            popUpTo("login")
                        }
                    }
                    else
                    {
                        Toast.makeText(Context,"Please read the rules and mark the checkbox.", Toast.LENGTH_LONG).show()
                    }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Start")
            }
        }
    }
}