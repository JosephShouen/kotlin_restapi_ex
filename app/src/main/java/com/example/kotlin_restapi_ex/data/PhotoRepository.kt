package com.example.kotlin_restapi_ex.data

//import com.example.kotlin_restapi_ex.model.Post
import Photo
import com.example.kotlin_restapi_ex.service.RetrofitInstance

class PhotoRepository {
    private val photoService = RetrofitInstance.photoService

    suspend fun getPhoto(): List<Photo> {
        return photoService.getPhotos()
    }
}