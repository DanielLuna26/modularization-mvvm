package com.softmoon.data.repositories

import com.softmoon.common.DispatcherProvider
import com.softmoon.common.Resource
import com.softmoon.common.SafeApiRequest
import com.softmoon.data.mapper.PostMapper
import com.softmoon.data.remote.PostService
import com.softmoon.domain.entity.Post
import com.softmoon.domain.repository.PostRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postService: PostService,
    private val dispatcher: DispatcherProvider,
    private val mapper: PostMapper
) : PostRepository, SafeApiRequest() {
    override suspend fun requestToGetPosts(): Resource<List<Post>> = withContext(dispatcher.io) {
        return@withContext when (val response = safeApolloRequest { postService.getPosts() }) {
            is Resource.Success ->
                Resource
                    .Success(
                        response
                            .value
                            .posts()!!
                            .map(mapper::mapFromEntity)

                    )
            is Resource.Failure -> response
            else -> Resource.Loading
        }
    }
}