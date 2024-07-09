package com.example.kotlin_restapi_ex.service

import Post
//import com.example.kotlin_restapi_ex.model.Post
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}