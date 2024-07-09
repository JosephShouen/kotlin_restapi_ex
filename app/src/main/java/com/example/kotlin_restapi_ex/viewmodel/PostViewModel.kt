package com.example.kotlin_restapi_ex.viewmodel

import Post
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_restapi_ex.data.PostRepository
//import com.example.kotlin_restapi_ex.model.Post
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _posts.value = posts
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}