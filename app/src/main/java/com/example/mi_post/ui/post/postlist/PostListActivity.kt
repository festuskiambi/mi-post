package com.example.mi_post.ui.post.postlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mi_post.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PostListActivity : AppCompatActivity() {

    @Inject
    lateinit var postListViewModelFactory: PostListViewModelFactory
    private lateinit var postListViewModel: PostListViewModel

    private lateinit var adapter: PostsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        postListViewModel = ViewModelProviders.of(this, postListViewModelFactory)
            .get(PostListViewModel::class.java)

        initViews()
    }

    private fun initViews() {
        postListViewModel.handleEvent(PostListEvent.onStart)
        setUpAdapter()
        observeViewModel()
    }

    private fun setUpAdapter() {
        adapter = PostsAdapter()
        adapter.event.observe(this,
            Observer { postListViewModel.handleEvent(it) })
        rv_list_posts.adapter = adapter
    }

    private fun observeViewModel() {
        postListViewModel.postList.observe(
            this,
            Observer {notelist ->
                adapter.submitList(notelist)
            }
        )
    }
}




