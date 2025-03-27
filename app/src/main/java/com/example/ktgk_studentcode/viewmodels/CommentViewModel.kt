package com.example.ktgk_studentcode.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktgk_studentcode.network.Comment
import com.example.ktgk_studentcode.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommentViewModel : ViewModel() {
    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val comments: StateFlow<List<Comment>> = _comments

    init {
        fetchComments()
    }

    fun fetchComments() {
        viewModelScope.launch {
            try {
                _comments.value = RetrofitClient.apiService.getComments()
            } catch (e: Exception) {
                Log.e("API ERROR", "Error fetching comments: ${e.message}")
            }
        }
    }
}
