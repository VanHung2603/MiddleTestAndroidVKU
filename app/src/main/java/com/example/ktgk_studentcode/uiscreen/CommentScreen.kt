package com.example.ktgk_studentcode.uiscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ktgk_studentcode.viewmodels.CommentViewModel

@Composable
fun CommentScreen(viewModel: CommentViewModel = hiltViewModel()) {
    val comments by viewModel.comments.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Comments List", style = MaterialTheme.typography.titleLarge)
        LazyColumn {
            items(comments) { comment ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = comment.name)
                        Text(text = comment.email)
                        Text(text = comment.body)
                    }
                }
            }
        }
    }
}

