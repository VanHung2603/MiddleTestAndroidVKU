package com.example.ktgk_studentcode.uiscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ktgk_studentcode.viewmodels.CustomerViewModel

@Composable
fun CustomerScreen(viewModel: CustomerViewModel = hiltViewModel()) {
    val customers by viewModel.customers.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Customers List", style = MaterialTheme.typography.titleLarge)
        LazyColumn {
            items(customers) { customer ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = customer.name)
                        Text(text = customer.email)
                        Text(text = customer.phoneNumber)
                    }
                }
            }
        }
    }
}