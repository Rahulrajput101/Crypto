package com.example.crypto.domain.use_cases

import com.example.crypto.common.Resource
import com.example.crypto.data.remote.dto.toCoinDetail
import com.example.crypto.domain.model.CoinDetail
import com.example.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.ResourceBundle
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    val repository: CoinRepository
) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetails = repository.getCoinDetail(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetails))
        }catch (e : HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: " An Error occurred"))
        }
        catch (e : IOException){
            emit(Resource.Error<CoinDetail>("Check the Internet"))
        }



    }
}