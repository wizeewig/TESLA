package com.example.tesla.screen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tesla.R
import com.example.tesla.Routes
import com.example.tesla.component.CustomTopAppBar
import com.example.tesla.ui.theme.Purple200
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun SignUp(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize().scrollable(state=scrollState, orientation = Orientation.Vertical)) {
        ScaffoldWithTopBar(navController)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldWithTopBar(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(
                    "Sign Up",
                    color = Color.White)},
                backgroundColor = Color(9,45,80),
                navigationIcon = {
                    if(navController.previousBackStackEntry != null){
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                }
            )
                 //CustomTopAppBar(navController = navController, title = "Sign Up", showBackIcon = true )
            },
         content = {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.loginsignup), contentDescription = "img",
                contentScale = ContentScale.FillBounds,
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp).scrollable(state=scrollState, orientation = Orientation.Vertical),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                var name by remember { mutableStateOf("") }
                var username by remember { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var passwordVisible by rememberSaveable{ mutableStateOf(false) }
                var cpassword by remember { mutableStateOf("") }
                var cpasswordVisible by rememberSaveable{ mutableStateOf(false) }
                var mobno by remember { mutableStateOf("") }
                var branch by remember { mutableStateOf("") }
                var year by remember { mutableStateOf("") }
                Text(text = "Sign Up", style = TextStyle( fontSize = 70.sp, fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, color = Color.White, shadow = Shadow(
                    color = Color.Black,
                    blurRadius = 3f
                )
                )
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Name") },
                    value = name,
                    onValueChange = { name = it },
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "Icon", tint = Color.White)
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier.border(
                        BorderStroke(width = 2.dp, color = Purple200),
                        shape = RoundedCornerShape(50),
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Go),
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Username") },
                    value = username,
                    onValueChange = { username = it },
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "Icon", tint = Color.White)
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier.border(
                        BorderStroke(width = 2.dp, color = Purple200),
                        shape = RoundedCornerShape(50),
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Email") },
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = "Icon", tint = Color.White)
                    },
                    shape = RoundedCornerShape(50.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Password") },
                    value = password,
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "Icon", tint = Color.White)
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {

                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Please provide localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = {passwordVisible = !passwordVisible}){
                            Icon(imageVector  = image, description, tint = Color.White)
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Confirm Password") },
                    value = cpassword,
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "Icon", tint = Color.White)
                    },
                    visualTransformation = if (cpasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {

                        val image = if (cpasswordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Please provide localized description for accessibility services
                        val description = if (cpasswordVisible) "Hide password" else "Show password"

                        IconButton(onClick = {cpasswordVisible = !cpasswordVisible}){
                            Icon(imageVector  = image, description, tint = Color.White)
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
                    onValueChange = { cpassword = it },
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Mobile Number") },
                    value = mobno,
                    onValueChange = { mobno = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.PhoneAndroid, contentDescription = "Icon", tint = Color.White)
                    },
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Branch") },
                    value = branch,
                    onValueChange = { branch = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Engineering, contentDescription = "Icon", tint = Color.White)
                    },
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    label = { Text(text = "Year") },
                    value = year,
                    onValueChange = { year = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Numbers, contentDescription = "Icon", tint = Color.White)
                    },
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
                    ))

                Spacer(modifier = Modifier.height(10.dp))

                val Context = LocalContext.current
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                            if(password!=cpassword){
                                Toast.makeText(Context,"Password and Confirm Password do not match.",Toast.LENGTH_LONG).show()
                            }
                            else if(name.isEmpty() || name.trim { it<=' ' }=="" || username.isEmpty() || username.trim { it<=' ' }=="" || email.isEmpty() || email.trim { it<=' ' }=="" || password.isEmpty() || password.trim { it<=' ' }=="" || mobno.isEmpty() || mobno.trim { it<=' ' }=="" || branch.isEmpty() || branch.trim { it<=' ' }=="" || year.isEmpty() || year.trim { it<=' ' }=="" || cpassword.isEmpty() || cpassword.trim { it<=' ' }==""){
                                Toast.makeText(Context,"Fill up all the details.",Toast.LENGTH_LONG).show()
                            }
                            else if(password.length<=5){
                                Toast.makeText(Context,"Enter a strong password of length greater than 5.",Toast.LENGTH_LONG).show()
                            }
                            else if(mobno.length!=10){
                                Toast.makeText(Context,"Enter correct Mobile Number. Do not add +91 as prefix.",Toast.LENGTH_LONG).show()
                            }
                            else {
//                                Toast.makeText(Context,"Signed Up successfully.",Toast.LENGTH_LONG).show()
//                                navController.navigate(Routes.Login.route) {
//                                    popUpTo("login")
//                                }
                                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Log.d("Firebase", "User registered successfully")

                                            val user = hashMapOf(
                                                "Name" to name,
                                                "Username" to username,
                                                "Email" to email,
                                                "Password" to password,
                                                "Mobile Number" to mobno,
                                                "Branch" to branch,
                                                "Year" to year,
                                                "Level" to "1"
                                            )
                                            val userID = Firebase.auth.currentUser?.uid
                                            if (userID != null) {
                                                Firebase.firestore.collection("users").document(userID).set(
                                                    user
                                                )
                                            }

//                                            Firebase.firestore.collection("users").add(user)
//                                                .addOnSuccessListener{
//
//                                                    Log.d("Firestore Database", "User registered")
//                                                }
//                                                .addOnFailureListener { e ->
//                                                    Log.w("Firestore Database", "Error registering User", e)
//                                                }
                                            Toast.makeText(Context,"Signed Up successfully.",Toast.LENGTH_LONG).show()
                                            navController.navigate(Routes.Login.route) {
                                                popUpTo("login")
                                            }
                                        } else {
                                            Log.e("Firebase", "Error registering user", task.exception)
                                            Toast.makeText(Context,"Sign Up unsuccessful. Please try again.",Toast.LENGTH_LONG).show()
                                        }

                                    }

//                                Toast.makeText(Context,"Signed Up successfully.",Toast.LENGTH_LONG).show()
//                                navController.navigate(Routes.Login.route) {
//                                    popUpTo("login")
//                                }
                            }
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Sign Up")
                    }
                }
            }
        })
}