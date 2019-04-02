package com.example.mi_post.ui.post.postlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mi_post.R
import dagger.android.AndroidInjection

class PostListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }
}
