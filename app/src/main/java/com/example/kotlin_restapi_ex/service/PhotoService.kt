package com.example.kotlin_restapi_ex.service

import Photo
//import com.example.kotlin_restapi_ex.model.Post
import retrofit2.http.GET

interface PhotoService {
    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}