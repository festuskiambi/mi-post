package com.example.mi_post.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mi_post.data.model.Post

/**
 * Created by Festus Kiambi on 2/21/19.
 */
@Dao
interface PostsDao {

    @Query("SELECT * FROM posts")
    fun queryPosts(): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)
}