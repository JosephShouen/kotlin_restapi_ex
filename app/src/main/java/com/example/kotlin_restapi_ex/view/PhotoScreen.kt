//package com.example.kotlin_restapi_ex.view
//
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.kotlin_restapi_ex.R
import com.example.kotlin_restapi_ex.viewmodel.PhotoViewModel


@Composable
fun PhotoScreen(viewModel: PhotoViewModel) {
    val photoCards by viewModel.photos.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchPhotos()
    }

    Column {
        if (photoCards.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(photoCards) { photoCards ->
                    Text(text = photoCards.albumID.toString())
                    Text(text = photoCards.title)
                    AsyncImage(
                        model = photoCards.thumbnailURL,
//                        model = "https://delasign.com/delasignBlack.png",
                        contentDescription = "The delasign logo"
                    )
                    Divider() // Add a divider between items
                }
            }
        }
    }
}