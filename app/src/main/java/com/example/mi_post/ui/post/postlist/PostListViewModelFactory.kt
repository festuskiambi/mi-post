package com.example.mi_post.ui.post.postlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mi_post.data.source.PostsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 3/21/19.
 */
class PostListViewModelFactory @Inject constructor(private val postsRepository: PostsRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            return PostListViewModel(postsRepository, Dispatchers.Main) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
