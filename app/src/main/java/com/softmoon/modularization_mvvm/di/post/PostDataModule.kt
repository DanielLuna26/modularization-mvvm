package com.softmoon.modularization_mvvm.di.post

import com.softmoon.data.remote.PostService
import com.softmoon.data.remote.PostServiceImpl
import com.softmoon.data.repositories.PostRepositoryImpl
import com.softmoon.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PostDataModule {
    @Binds
    fun bindPostService(postService: PostServiceImpl): PostService

    @Binds
    fun bindPostRepository(postRepository: PostRepositoryImpl): PostRepository
}