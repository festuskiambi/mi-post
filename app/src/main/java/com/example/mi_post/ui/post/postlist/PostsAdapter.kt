package com.example.mi_post.ui.post.postlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mi_post.R
import com.example.mi_post.data.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Created by Festus Kiambi on 3/27/19.
 */

class PostsAdapter(var event: MutableLiveData<PostListEvent> = MutableLiveData()) :
    ListAdapter<Post, PostsAdapter.PostViewHolder>(PostDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PostViewHolder(
            inflater.inflate(R.layout.item_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position).let { post ->
            with(holder) {
                holder.body.text = post.body
                holder.title.text = post.title
            }
        }
    }

    class PostViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        var body: TextView = root.tv_body
        var title: TextView = root.tv_title
    }

}