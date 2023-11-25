package com.frisel.registry.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.frisel.registry.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    userViewModel: UserViewModel = viewModel(factory = UserViewModel.factory),
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .background(Color.Gray)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextField(value = userViewModel.userText.value,
                    onValueChange = {
                        userViewModel.userText.value = it
                },
                    label = {
                        Text(text = "First name")
                    },
                )
                Spacer(modifier = Modifier.padding(10.dp))

                TextField(value = userViewModel.userText2.value, onValueChange = {
                    userViewModel.userText2.value = it
                },
                    label = {
                        Text(text = "Last name")
                    },
                )
                Spacer(modifier = Modifier.padding(10.dp))

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                    onClick = {userViewModel.insertUser()}) {
                    Text(text = "Добавить")
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                    onClick = { navController.navigate(Screen.ViewScreenUser.route)}) {
                    Text(text = "Просмотреть")
                }

            }

        }
}
