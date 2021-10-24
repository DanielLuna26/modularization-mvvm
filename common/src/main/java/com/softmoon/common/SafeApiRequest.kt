package com.softmoon.common

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.exception.ApolloHttpException
import com.apollographql.apollo.exception.ApolloNetworkException
import retrofit2.HttpException
import java.lang.Exception

abstract class SafeApiRequest {
    suspend fun <T> safeApolloRequest(call: suspend () -> Response<T>) : Resource<T> {
        return try {
            val response = call.invoke()

            if (response.data.isNull() && response.hasErrors())
                Resource.Failure(false, null, null)
            else
                Resource.Success(response.data!!)
        } catch (throwable: Throwable) {
            when (throwable) {
                is ApolloNetworkException ->
                    Resource.Failure(true, null, null)
                is ApolloHttpException ->
                    Resource.Failure(false, throwable.code(), throwable.message())
                else ->
                    Resource.Failure(false, null, throwable.message)
            }

        }
    }

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ) : Resource<T> {
        return try {
            Resource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when(throwable) {
                is HttpException ->
                    Resource
                        .Failure(
                            false,
                            throwable.response()?.code(),
                            throwable.response()?.message()
                        )
                is NoInternetException ->
                    Resource.Failure(true, null, null)
                else ->
                    Resource.Failure(false, null, throwable.message)
            }
        }
    }
}