package com.softmoon.presentation.ui.posts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.softmoon.common.Resource
import com.softmoon.common.handleApiErrors
import com.softmoon.common.viewBinding
import com.softmoon.presentation.R
import com.softmoon.presentation.databinding.FragmentPostsBinding
import com.softmoon.presentation.recycler_view.adapters.PostsRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragment_posts) {

    val viewModel by viewModels<PostsViewModel>()
    private val binding by viewBinding(FragmentPostsBinding::bind)

    private lateinit var postsAdapter: PostsRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        postsAdapter = PostsRecyclerViewAdapter()

        setUpRecycler()
        runObservers()
    }

    private fun setUpRecycler() {
        binding.postsRvItems.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = postsAdapter
        }
    }

    private fun runObservers() {
        viewModel.result.asLiveData().observe(viewLifecycleOwner) { response ->
            response ?: return@observe

            when (response) {
                is Resource.Failure -> {
                    handleApiErrors(response)
                    binding.postsSwItems.isRefreshing = false
                }
                is Resource.Success -> {
                    postsAdapter.items = response.value
                    binding.postsSwItems.isRefreshing = false
                }
                is Resource.Loading -> binding.postsSwItems.isRefreshing = true
            }
        }
    }

}