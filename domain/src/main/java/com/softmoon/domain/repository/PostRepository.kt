package com.softmoon.domain.repository

import com.softmoon.common.Resource
import com.softmoon.domain.entity.Post

interface PostRepository {
    suspend fun requestToGetPosts() : Resource<List<Post>>
}