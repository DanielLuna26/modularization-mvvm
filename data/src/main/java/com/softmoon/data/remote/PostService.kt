package com.softmoon.data.remote

import com.apollographql.apollo.api.Response
import com.softmoon.PostQuery

interface PostService {
    suspend fun getPosts(): Response<PostQuery.Data>
}