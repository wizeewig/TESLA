package com.example.tesla.screen

import android.annotation.SuppressLint
import android.media.Image
import android.text.util.Linkify
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
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
fun developer(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBarDeveloper(navController as NavHostController)
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldWithTopBarDeveloper(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "Developer", true)
        }, content =
        {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(R.drawable.devimg),
                    contentDescription = "developer image",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Ikchhit Kumar Pandey", style = TextStyle(
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

                Text(
                    text = "Github account", style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        shadow = Shadow(
                            color = Color.Yellow,
                            blurRadius = 4f
                        )
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column() {
                    Row() {
                        Image(painter = painterResource(id = R.drawable.githubicon), contentDescription = "Insta Icon",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(24.dp));
                        Spacer(modifier = Modifier.padding(8.dp))
                        LinkText(linkTextData = listOf(
                            LinkTextData(text = "Github",
                                tag = "Github icon",
                                annotation = "https://www.github.com/wizeewig",)
                        ) )
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))


                Text(
                    text = "Follow me on:", style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        shadow = Shadow(
                            color = Color.Yellow,
                            blurRadius = 4f
                        )
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column() {
                    Row() {
                        Image(painter = painterResource(id = R.drawable.instaicon), contentDescription = "Insta Icon",
                            contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp));
                        Spacer(modifier = Modifier.padding(8.dp))
                        LinkText(linkTextData = listOf(
                            LinkTextData(text = "Instagram",
                                tag = "insta icon",
                                annotation = "https://www.instagram.com/ikchhit_pandey/?utm_medium=copy_link",)
                        ) )
                    }
                }
            }
        })
}