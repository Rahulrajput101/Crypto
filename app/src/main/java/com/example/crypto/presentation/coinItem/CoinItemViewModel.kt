package com.example.crypto.presentation.coinItem

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.Resource
import com.example.crypto.domain.use_cases.CoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinItemViewModel @Inject constructor(
    val useCase: CoinsUseCase
) :  ViewModel() {

    private val _state = mutableStateOf(CoinItemState())
    val state : State<CoinItemState> =_state

init {
    getCoinItems()
}


    fun getCoinItems(){
          useCase().onEach {result ->
              when(result){

                  is Resource.Success -> {
                      _state.value = CoinItemState(data = result.data?: emptyList())
                  }

                  is Resource.Error -> {
                      _state.value = CoinItemState(error = result.message ?: " An Error occurred")
                  }

                  is Resource.Loading -> {
                           _state.value = CoinItemState(isLoading = true)
                  }

              }

          }.launchIn(viewModelScope)


    }
}