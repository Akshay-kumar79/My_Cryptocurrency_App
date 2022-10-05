package com.akshaw.cryptocurrency.domain.use_case.get_coins

import com.akshaw.cryptocurrency.common.Resource
import com.akshaw.cryptocurrency.data.remote.dto.toCoins
import com.akshaw.cryptocurrency.domain.model.Coin
import com.akshaw.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoins() }
            emit(Resource.Success(coins))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server, Check your internet connection"))
        }
    }

}