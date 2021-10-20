package com.softmoon.data.repositories

import com.softmoon.common.DispatcherProvider
import com.softmoon.common.Resource
import com.softmoon.domain.entity.Post
import com.softmoon.domain.repository.PostRepository
import kotlinx.coroutines.withContext

class PostRepositoryImpl(
    private val dispatcher: DispatcherProvider
) : PostRepository {
    override suspend fun requestToGetPosts(): Resource<List<Post>> = withContext(dispatcher.io) {
        Resource.Success(emptyList())
    }
}