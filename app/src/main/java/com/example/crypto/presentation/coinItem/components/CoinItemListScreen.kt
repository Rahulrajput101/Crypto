package com.example.crypto.presentation.coinItem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.crypto.Screen
import com.example.crypto.presentation.coinItem.CoinItemViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CoinItemListScreen(
    navController: NavController,
    viewModel: CoinItemViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
           items(state.data){coin->
               CoinItemScreen(coinItem = coin,
               onItemClick = {
                   navController.navigate(Screen.DetailScreen.route +"/${coin.id}")
               }
                   )
               
           }

        }

        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = Color.Red,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )

        }

        if(state.isLoading){
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }





    }





}
