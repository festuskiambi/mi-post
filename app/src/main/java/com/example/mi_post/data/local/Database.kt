package com.example.mi_post.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mi_post.data.model.Post

/**
 * Created by Festus Kiambi on 2/21/19.
 */
@Database(
    entities = arrayOf(Post::class), version = 1
)
abstract class Database : RoomDatabase() {

    abstract fun postsDao(): PostsDao

}