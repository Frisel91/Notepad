package com.frisel.registry.ui

sealed class Screen(val route: String){
    object RegisterScreen : Screen("register_screen")
    object ViewScreenUser : Screen("view_screen_user")
}
