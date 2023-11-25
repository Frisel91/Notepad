package com.frisel.registry

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.frisel.registry.db.AppDatabase
import com.frisel.registry.db.User
import kotlinx.coroutines.launch

class UserViewModel(val database: AppDatabase): ViewModel() {
    val dataItem = database.userDAO.getAllUser()
    val userText = mutableStateOf("")
    val userText2 = mutableStateOf("")
    fun insertUser() = viewModelScope.launch{
        val  nameUser = User(firstName = userText.value, lastName = userText2.value)
        database.userDAO.insertUser(nameUser)
        userText.value = ""
        userText2.value = ""
    }


    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel>
                    create(
                modelClass: Class<T>,
                extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).db
                return UserViewModel(database) as T
            }
        }
    }
}