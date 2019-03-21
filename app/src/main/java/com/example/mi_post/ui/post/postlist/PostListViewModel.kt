package com.example.mi_post.ui.post.postlist

import com.example.mi_post.base.BaseViewModel
import com.example.mi_post.data.source.PostsRepository
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by Festus Kiambi on 2/22/19.
 */
class PostListViewModel @Inject constructor(
    val postsRepository: PostsRepository,
    uiContext: CoroutineContext
) : BaseViewModel<PostListEvent>(uiContext) {

    override fun handleEvent(event: PostListEvent) {

    }
}