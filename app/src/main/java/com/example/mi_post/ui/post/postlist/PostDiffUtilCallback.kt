package com.example.mi_post.ui.post.postlist

import androidx.recyclerview.widget.DiffUtil
import com.example.mi_post.data.model.Post

/**
 * Created by Festus Kiambi on 3/27/19.
 */
class PostDiffUtilCallback: DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }
}