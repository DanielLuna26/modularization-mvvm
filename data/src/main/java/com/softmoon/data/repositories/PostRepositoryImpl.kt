package com.softmoon.data.repositories

import com.softmoon.PostQuery
import com.softmoon.common.DispatcherProvider
import com.softmoon.common.Resource
import com.softmoon.common.SafeApolloRequest
import com.softmoon.data.remote.PostService
import com.softmoon.domain.entity.Post
import com.softmoon.domain.repository.PostRepository
import kotlinx.coroutines.withContext

class PostRepositoryImpl(
    private val postService: PostService,
    private val dispatcher: DispatcherProvider
) : PostRepository, SafeApolloRequest() {
    override suspend fun requestToGetPosts(): Resource<List<Post>> = withContext(dispatcher.io) {
        return@withContext when (val response = apolloRequest { postService.getPosts() }) {
            is Resource.Success ->
                Resource
                    .Success(
                        response.value.map {
                            Post(it.userId()!!, it.id()!!, it.title()!!, it.body()!!)
                        }
                    )
            is Resource.Failure -> response
            else -> Resource.Loading
        }
    }
}