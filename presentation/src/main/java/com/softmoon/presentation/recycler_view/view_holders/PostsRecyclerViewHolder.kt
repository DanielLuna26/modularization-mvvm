package com.softmoon.presentation.recycler_view.view_holders

import androidx.recyclerview.widget.RecyclerView
import com.softmoon.domain.entity.Post
import com.softmoon.presentation.databinding.ItemPostBinding

class PostsRecyclerViewHolder (
    private val binding: ItemPostBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.post = post
    }
}