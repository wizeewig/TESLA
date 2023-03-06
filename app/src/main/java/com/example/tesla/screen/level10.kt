package com.example.tesla.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Leaderboard
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.example.tesla.R
import com.example.tesla.Routes
import com.example.tesla.ui.theme.Purple200
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun level10(navController: NavController){

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MyTopAppBar10(navController, scaffoldState, scope) },
        drawerContent = { drawerContent10(navController)} ,
        content = { MyContent10(navController) }
    )
}

@Composable
fun MyContent10(navController: NavController){

    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.ten), contentDescription = "img",
        contentScale = ContentScale.FillBounds,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var ans by remember { mutableStateOf("") }

        Image(painter = painterResource(id = R.drawable.level10), contentDescription = "welcomerules", modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            label = { Text(text = "Enter your answer") },
            value = ans,
            onValueChange = { ans = it },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Filled.QuestionAnswer, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Go),
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

        Spacer(modifier = Modifier.height(20.dp))

        val Context = LocalContext.current

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 40.dp)) {
            Button(

                onClick = {
                    if(ans.isEmpty() || ans.trim { it<=' ' }==""){
                        Toast.makeText(Context, "Please enter your answer", Toast.LENGTH_LONG).show()
                    }
                    else if(ans == "level10ans"){
                        Toast.makeText(Context, "Félicitations! You advance to next level.", Toast.LENGTH_LONG).show()

                        val UserID= Firebase.auth.currentUser?.uid
                        val docRef = UserID?.let {
                            Firebase.firestore.collection("users").document(it)
                        }
                        if (docRef != null) {
                            docRef.update("Level", "11")
                        }

                        navController.navigate(Routes.level11.route){
                            popUpTo("login")
                        }
                    }
                    else{
                        //Toast.makeText(Context,ans, Toast.LENGTH_LONG).show()
                        Toast.makeText(Context, "Wrong Answer! Please try again.", Toast.LENGTH_LONG).show()
                    }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Submit")
            }
        }

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyTopAppBar10( navController:NavController, scaffoldState: ScaffoldState, scope: CoroutineScope) {

    val listItems = getMenuItemsList10()
    val contextForToast = LocalContext.current.applicationContext

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector= Icons.Filled.Menu, contentDescription = "Opens Navigation Drawer", tint = Color.White)
            }
        },
        title = {
            Text(text = "LEVEL 10" ,color = Color.White)
        },
        backgroundColor = Color(10,9,43),
        actions = {

            //Notification Icon
//            IconButton(onClick = {
//                navController.navigate(Routes.status.route)
//            }) {
//                Icon(
//                    imageVector = Icons.Filled.Details,
//                    contentDescription = "Open details",
//                    tint = Color.White
//                )
//            }

            // 3 vertical dots icon
            IconButton(onClick = {
                expanded = true
            }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Open Options",
                    tint = Color.White
                )
            }

            // drop down menu
            DropdownMenu(
                modifier = Modifier.width(width = 157.dp),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                // adjust the position
                offset = DpOffset(x = (-102).dp, y = (-64).dp),
                properties = PopupProperties()
            ) {

                // adding each menu item
                listItems.forEach { menuItemData ->
                    DropdownMenuItem(
                        onClick = {

                                Firebase.auth.signOut()
                                Toast.makeText(contextForToast, menuItemData.text + " successful", Toast.LENGTH_SHORT).show()
                                navController.navigate(Routes.Login.route){
                                    popUpTo("login")
                                }

                            expanded = false
                        },
                        enabled = true
                    ) {

                        Icon(
                            imageVector = menuItemData.icon,
                            contentDescription = menuItemData.text,
                            tint = Color.Black
                        )

                        Spacer(modifier = Modifier.width(width = 8.dp))

                        Text(
                            text = menuItemData.text,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    )
}



fun getMenuItemsList10(): ArrayList<MenuItemData10> {
    val listItems = ArrayList<MenuItemData10>()

//    listItems.add(MenuItemData10(text = "Leaderboard", icon = Icons.Outlined.Leaderboard))
    listItems.add(MenuItemData10(text = "Logout", icon = Icons.Outlined.Logout))
//    listItems.add(MenuItemData(text = "Mail", icon = Icons.Outlined.Mail))
//    listItems.add(MenuItemData(text = "About", icon = Icons.Outlined.Info))

    return listItems
}

data class MenuItemData10(val text: String, val icon: ImageVector)

data class DrawerContent10(val title: String, val imageVector: ImageVector, val id: String)

@Composable
fun drawerContent10(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(8.dp))
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "eellogo", modifier = Modifier.fillMaxWidth())
        Divider(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp))
        Spacer(modifier = Modifier.height(10.dp))

        val list= mutableListOf<DrawerContent10>(
            DrawerContent10(title="Rules", imageVector = Icons.Filled.Rule, id = "rulesdrawer"),
            DrawerContent10(title = "About Tesla", imageVector = Icons.Filled.Apps, id = "tesla"),
            DrawerContent10(title = "About EEL", imageVector = Icons.Filled.ElectricalServices, id = "eel"),
            DrawerContent10(title = "About Developer" , imageVector = Icons.Filled.DeveloperMode, id = "developer")
        )

        LazyColumn{
            items(list){
                DrawerItem10(it,navController)
            }
        }
    }
}

@Composable
fun DrawerItem10(it: DrawerContent10, navController: NavController){

    val itemClick=it.id

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Icon(imageVector = it.imageVector, contentDescription = null, modifier = Modifier.padding(8.dp))
//        Text(text = it.title, style = TextStyle(color= Color.Black, fontSize = 20.sp), modifier = Modifier.padding(8.dp))
        ClickableText(
            text = AnnotatedString(it.title),
            onClick = {
                if(itemClick=="rulesdrawer"){
                    navController.navigate(Routes.rulesdrawer.route)
                }
                else if(itemClick=="tesla"){
                    navController.navigate(Routes.tesla.route)
                }
                else if(itemClick=="eel"){
                    navController.navigate(Routes.eel.route)
                }
                else if(itemClick=="developer"){
                    navController.navigate(Routes.developer.route)
                }
            },
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                color = Color.Black
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}
