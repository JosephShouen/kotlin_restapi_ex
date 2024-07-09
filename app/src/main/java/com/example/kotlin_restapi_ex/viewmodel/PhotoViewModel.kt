package com.example.kotlin_restapi_ex.viewmodel

import Photo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_restapi_ex.data.PhotoRepository
//import com.example.kotlin_restapi_ex.model.Post
import kotlinx.coroutines.launch

class PhotoViewModel : ViewModel() {
    private val repository = PhotoRepository()

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun fetchPhotos() {
        viewModelScope.launch {
            try {
                val photos = repository.getPhoto()
                _photos.value = photos
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}