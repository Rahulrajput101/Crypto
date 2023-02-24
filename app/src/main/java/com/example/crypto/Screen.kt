package com.example.crypto

sealed class Screen(val route : String){

    object ListScreen : Screen("list_screen")
    object DetailScreen : Screen("detail_screen")

}
