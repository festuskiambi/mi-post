package com.example.mi_post.di.modules

import android.app.Application
import androidx.room.Room
import com.example.mi_post.data.local.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Festus Kiambi on 2/21/19.
 */
@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun providePostsDatabase(app: Application) = Room.databaseBuilder(
        app, Database::class.java, "posts"
    ).build()

    @Provides
    @Singleton
    fun providePostsDao(database: Database) = database.postsDao()
}