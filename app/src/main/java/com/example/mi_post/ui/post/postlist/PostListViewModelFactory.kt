package com.example.mi_post.ui.post.postlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 3/21/19.
 */
class PostListViewModelFactory @Inject constructor(val postListViewModel: PostListViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java!!)) {
            return postListViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
