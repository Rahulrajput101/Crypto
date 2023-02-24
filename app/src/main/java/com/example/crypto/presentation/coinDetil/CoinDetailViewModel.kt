package com.example.crypto.presentation.coinDetil

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.Constants
import com.example.crypto.common.Resource
import com.example.crypto.domain.use_cases.CoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val useCase: CoinDetailUseCase,
    private val savedStateHandle  : SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(CoinDetailState())
    val state : MutableState<CoinDetailState> = _state


    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinID->
            getCoinDetail(coinID)

        }
    }
     fun getCoinDetail(coinId : String) {

        useCase(coinId).onEach { result ->
            when(result){

                is Resource.Success -> {
                     _state.value = CoinDetailState(coin = result.data)
                }


                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message?: "An error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }





            }
        }.launchIn(viewModelScope)





    }



}