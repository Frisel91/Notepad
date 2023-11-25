package com.frisel.registry.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.frisel.registry.UserViewModel

@Composable
fun ViewScreenUser(    userViewModel: UserViewModel = viewModel(factory = UserViewModel.factory)) {
    val itemList = userViewModel.dataItem.collectAsState(initial = emptyList())
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 20.dp, horizontal = 5.dp)){
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(itemList.value){item ->
                ListItem(item)
            }
        }
    }
}