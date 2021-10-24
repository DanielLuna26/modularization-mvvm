package com.softmoon.modularization_mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.apollographql.apollo.ApolloClient
import com.softmoon.common.DispatcherProvider
import com.softmoon.data.remote.PostService
import com.softmoon.data.remote.PostServiceImpl
import com.softmoon.data.repositories.PostRepositoryImpl
import com.softmoon.domain.interactors.GetPostUseCase
import com.softmoon.domain.repository.PostRepository
import com.softmoon.modularization_mvvm.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var remoteDataSource: PostService
    private lateinit var postRepository: PostRepository
    private lateinit var getPostUseCase: GetPostUseCase
    private val dispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apolloClient = ApolloClient
            .builder()
            .serverUrl("https://json-placeholder-graphql.herokuapp.com/graphql")
            .build()

        remoteDataSource = PostServiceImpl(apolloClient)
        postRepository = PostRepositoryImpl(
            remoteDataSource,
            dispatcherProvider
        )

        getPostUseCase = GetPostUseCase(postRepository)

        GlobalScope.launch {
            getPostUseCase.invoke().collect {
                Log.d("GetPostUseCase", "$it")
            }
        }

    }
}