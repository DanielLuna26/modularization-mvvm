package com.softmoon.common

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import java.lang.Exception

abstract class SafeApolloRequest {
    suspend fun <T> apolloRequest(call: suspend () -> Response<T>) : Resource<T> {
        return try {
            val response = call.invoke()

            if (response.data.isNull() && response.hasErrors())
                Resource.Failure(false, 400, "request error")
            else
                Resource.Success(response.data!!)
        } catch (throwable: ApolloException) {
            Resource.Failure(false, throwable.cause.hashCode(), throwable.message)
        }
    }
}