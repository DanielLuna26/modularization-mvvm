package com.softmoon.data.mapper

import com.softmoon.PostQuery
import com.softmoon.domain.entity.Post
import javax.inject.Inject

class PostMapper @Inject constructor(): Mapper<PostQuery.Post, Post> {
    override fun mapFromEntity(type: PostQuery.Post): Post = with(type) {
        Post(
            userId()!!,
            id()!!,
            title()!!,
            body()!!
        )
    }
}