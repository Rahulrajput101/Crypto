package com.example.crypto.domain.use_cases

import com.example.crypto.common.Resource
import com.example.crypto.data.remote.dto.CoinItemDto
import com.example.crypto.data.remote.dto.toCoin
import com.example.crypto.domain.model.CoinItem
import com.example.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinsUseCase @Inject constructor(
    val repository: CoinRepository
) {

    operator fun invoke () : Flow<Resource<List<CoinItem>>> = flow {
        try {
            emit(Resource.Loading<List<CoinItem>>())
            val coins = repository.getCoin().map { it.toCoin() }
            emit(Resource.Success<List<CoinItem>>(coins))
        }catch (e : HttpException){
            emit(Resource.Error<List<CoinItem>>(e.localizedMessage ?: "An Unexpected error Occurred"))
        }catch (e : IOException){
            emit(Resource.Error<List<CoinItem>>("Check the Internet"))
        }

    }
}