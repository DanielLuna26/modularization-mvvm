package com.softmoon.data.remote

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.softmoon.PostQuery

class PostServiceImpl (
    private val apolloClient: ApolloClient
): PostService {
    override suspend fun getPosts(): Response<PostQuery.Data> {
        return apolloClient.query(PostQuery()).await()
    }

}