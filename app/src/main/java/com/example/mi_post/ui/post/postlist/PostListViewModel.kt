package com.example.mi_post.ui.post.postlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mi_post.base.BaseViewModel
import com.example.mi_post.data.model.Post
import com.example.mi_post.data.source.PostsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by Festus Kiambi on 2/22/19.
 */
class PostListViewModel @Inject constructor(
    val postsRepository: PostsRepository,
    uiContext: CoroutineContext
) : BaseViewModel<PostListEvent>(uiContext) {

    private val postListState = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>> get() = postListState

    override fun handleEvent(event: PostListEvent) {
        when (event) {
            is PostListEvent.onStart -> getposts()
            is PostListEvent.onPostItemClicked -> navigateToPostDetail(event.position)
        }
    }

    private fun navigateToPostDetail(position: Int) {

    }

    private fun getposts() = launch {
        val result = postsRepository.getPosts()
        postListState.value = result
    }
}