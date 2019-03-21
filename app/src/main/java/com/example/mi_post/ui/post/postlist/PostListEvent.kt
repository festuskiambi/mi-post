package com.example.mi_post.ui.post.postlist

/**
 * Created by Festus Kiambi on 3/21/19.
 */
sealed class PostListEvent {
    data class onPostItemClicked(val position: Int): PostListEvent()
    object onStart : PostListEvent()
}