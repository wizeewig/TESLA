package com.example.tesla.screen


import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tesla.R
import com.example.tesla.Routes
import com.example.tesla.ui.theme.Purple200
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


val currentUser = Firebase.auth.currentUser

@Composable
fun LoginPage(navController: NavHostController) {

//    val scrollState = rememberScrollState()
        Box(modifier = Modifier.fillMaxSize()) {

            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.loginsignup), contentDescription = "img",
                contentScale = ContentScale.FillBounds,
            )

            Text(
                text = "Don't have an account?",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(42.dp)
            )

            ClickableText(
                text = AnnotatedString("Sign Up here"),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = {
                    navController.navigate(Routes.SignUp.route)
                },
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                    textDecoration = TextDecoration.Underline,
                    color = Color.White
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
//                .scrollable(state = scrollState, orientation = Orientation.Vertical)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var passwordVisible by rememberSaveable { mutableStateOf(false) }

            Text(
                text = "Login", style = TextStyle(
                    fontSize = 70.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Black,
                        blurRadius = 3f
                    )
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Email") },
                value = email,
                onValueChange = { email = it },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Icon",
                        tint = Color.White
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.border(
                    BorderStroke(width = 2.dp, color = Purple200),
                    shape = RoundedCornerShape(50),
                ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    textColor = Color.White,
                    backgroundColor = Color.DarkGray,
                    leadingIconColor = Color.White,
                    trailingIconColor = Color.White,
                    disabledTrailingIconColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                label = { Text(text = "Password") },
                value = password,
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Password,
                        contentDescription = "Icon",
                        tint = Color.White
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {

                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description, tint = Color.White)
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
                onValueChange = { password = it },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.border(
                    BorderStroke(width = 2.dp, color = Purple200),
                    shape = RoundedCornerShape(50)
                ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    textColor = Color.White,
                    backgroundColor = Color.DarkGray,
                    leadingIconColor = Color.White,
                    trailingIconColor = Color.White,
                    disabledTrailingIconColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            val Context = LocalContext.current
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {

                        if (email.isEmpty() || email.trim { it <= ' ' } == "" || password.isEmpty() || password.trim { it <= ' ' } == "") {
                            Toast.makeText(Context, "Fill up all the details.", Toast.LENGTH_LONG)
                                .show()
                        } else {
//                        val currentUser = Firebase.auth.currentUser
//                        if (currentUser != null) {
//                            TODO()
//                        } else {
                            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Log.d("Firebase", "User logged in successfully")
                                        Toast.makeText(
                                            Context,
                                            "Logged in successfully.",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        navController.navigate(Routes.Rules.route) {
                                            popUpTo("login")
                                        }
                                    } else {
                                        Log.e("Firebase", "Error logging in user", task.exception)
                                        Toast.makeText(
                                            Context,
                                            "Invalid Credentials.",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
//                    Toast.makeText(Context,"Logged in successfully.",Toast.LENGTH_LONG).show()
//                    navController.navigate(Routes.Rules.route){
//                        popUpTo("login")
//                    }
                            //}
                        }
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Login")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            ClickableText(
                text = AnnotatedString("Forgot password?"),
                onClick = {
                    navController.navigate(Routes.ForgotPassword.route)
                },
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                    color = Color.White
                )
            )
        }
}