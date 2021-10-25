package com.softmoon.modularization_mvvm.di.post

import com.softmoon.domain.interactors.GetPostsUseCaseImpl
import com.softmoon.domain.interactors.GetPostsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface PostDomainModule {
    @Binds
    fun bindGetPostUseCase(getPostUseCase: GetPostsUseCaseImpl): GetPostsUseCase
}