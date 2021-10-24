package com.softmoon.domain.interactors

import com.softmoon.common.Resource
import com.softmoon.domain.entity.Post
import com.softmoon.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPostUseCase constructor(private val repository: PostRepository) {
    suspend operator fun invoke() : Flow<Resource<List<Post>>> = flow {
        emit(Resource.Loading)

        emit(repository.requestToGetPosts())
    }
}