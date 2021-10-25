package com.softmoon.domain.interactors

import com.softmoon.common.Resource
import com.softmoon.domain.entity.Post
import kotlinx.coroutines.flow.Flow

interface GetPostsUseCase {
    suspend operator fun invoke() : Flow<Resource<List<Post>>>
}