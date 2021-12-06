package com.softmoon.presentation.recycler_view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softmoon.common.basicDiffUtil
import com.softmoon.domain.entity.Post
import com.softmoon.presentation.databinding.ItemPostBinding
import com.softmoon.presentation.recycler_view.view_holders.PostsRecyclerViewHolder

class PostsRecyclerViewAdapter: RecyclerView.Adapter<PostsRecyclerViewHolder>() {

    var items: List<Post> by basicDiffUtil(
        areItemsTheSame = { new, old ->
            new.id == old.id
        },
        areContentsTheSame = { new, old ->
            new == old
        }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsRecyclerViewHolder =
        PostsRecyclerViewHolder(
            ItemPostBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun onBindViewHolder(holder: PostsRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}