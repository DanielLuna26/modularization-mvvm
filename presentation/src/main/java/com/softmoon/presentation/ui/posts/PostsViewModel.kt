package com.softmoon.presentation.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softmoon.common.Resource
import com.softmoon.domain.entity.Post
import com.softmoon.domain.interactors.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {
    private val _result = MutableStateFlow<Resource<List<Post>>?>(null)
    val result: StateFlow<Resource<List<Post>>?> = _result

    init {
        requestPosts()
    }

    fun requestPosts() = viewModelScope.launch {
        getPostsUseCase().collect {
            _result.value = it
        }
    }

    fun resetResult() {
        _result.value = null
    }
}