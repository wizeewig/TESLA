package com.example.tesla.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tesla.component.CustomTopAppBar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


//val UserID= Firebase.auth.currentUser?.uid
//val docRef = UserID?.let {
//    Firebase.firestore.collection("users").document(it)
//}


@Composable
fun status(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBarStatus(navController as NavHostController)
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldWithTopBarStatus(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "Leaderboard", true)
        }

    ) {

//        val UserID = Firebase.auth.currentUser?.uid
//        val docRef = UserID?.let {
//            Firebase.firestore.collection("users").document(it)
//        }
//        var level: String = ""
//        var uname: String = ""
//        if (docRef != null) {
//            docRef.get().addOnSuccessListener { documentSnapshot ->
//                val data = documentSnapshot.data
//                data?.let {
//                    for (key in it.keys) {
//                        Log.d("Map traversal", key)
//                        if (key == "Level") {
//                            Log.d("Map traversalll", key + "kk" + it[key])
//                            level= it[key] as String
//
//                        } else if (key == "Username") {
//                            uname = uname+it[key]
//                        }
//                    }
//                }
//            }
//        }
//        Firebase.firestore.collection("users").get().addOnSuccessListener { querySnapshot ->
//            querySnapshot.forEach { document ->
//                Log.d("hello it is what is","${document.id} => ${document.data}")
//            }
//        }
//            .addOnFailureListener { exception ->
//                println("Error getting documents: $exception")
//            }
//
//        Log.d("Map traversal", "$level")
        val arr = arrayOf<String>(" ","Email","Level","Branch","Year")
        var username=""
        val theMap = HashMap<String, String>()
        val db = Firebase.firestore
        db.collection("users")
            .get()
            .addOnSuccessListener { querySnapshot ->
                querySnapshot.forEach { document ->
                    if (document.id == Firebase.auth.currentUser?.uid) {
                        document.data.entries.forEach { entry ->
                            if(entry.key == "Username") {
                                arr[0]= entry.value as String
                            }
                            if(entry.key == "Email") {
                                arr[1]= entry.value as String
                            }
                            if(entry.key == "Level") {
                                arr[2]= entry.value as String
                            }
                            if(entry.key == "Branch") {
                                arr[3]= entry.value as String
                            }
                            if(entry.key == "Year") {
                                arr[3]= entry.value as String
                            }
                            //Log.d("ALL ENTRIES", "${entry.key} => ${entry.value}")

                        }
                    }
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }

        Column(
            modifier = Modifier
                .fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Hello" + arr[0],
                fontSize = 30.sp,
                color = Color.Black
            )
        }
    }
}




