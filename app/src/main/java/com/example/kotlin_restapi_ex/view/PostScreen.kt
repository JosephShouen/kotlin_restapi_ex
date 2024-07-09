//package com.example.kotlin_restapi_ex.view
//
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.kotlin_restapi_ex.viewmodel.PostViewModel


@Composable
fun PostScreen(viewModel: PostViewModel) {
    val postCards by viewModel.posts.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column {
        if (postCards.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(postCards) { postCards ->
                    Text(text = postCards.userID.toString())
                    Text(text = postCards.body)
                    Text(text = postCards.title)
                    Divider() // Add a divider between items
                }
            }
        }
    }
}