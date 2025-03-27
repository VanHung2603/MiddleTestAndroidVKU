package com.example.ktgk_studentcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.ktgk_studentcode.uiscreen.CommentScreen
import com.example.ktgk_studentcode.uiscreen.CustomerScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Customer & Comments App") })
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "customers",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("customers") { CustomerScreen() }
            composable("comments") { CommentScreen() }
        }
    }
}