package com.example.kotlin_restapi_ex.data

//import com.example.kotlin_restapi_ex.model.Post
import Post
import com.example.kotlin_restapi_ex.service.RetrofitInstance

class PostRepository {
    private val postService = RetrofitInstance.postService

    suspend fun getPosts(): List<Post> {
        return postService.getPosts()
    }
}