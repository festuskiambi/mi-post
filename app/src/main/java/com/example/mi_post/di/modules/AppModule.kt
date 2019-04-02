package com.example.mi_post.di.modules

import android.app.Application
import androidx.room.Room
import com.example.mi_post.data.source.PostsRepository
import com.example.mi_post.data.source.local.Database
import com.example.mi_post.data.source.local.PostsDao
import com.example.mi_post.data.source.remote.ApiInterface
import com.example.mi_post.ui.post.postlist.PostListViewModelFactory
import com.example.mi_post.utils.NetworkConnectivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Festus Kiambi on 2/21/19.
 */
@Module
class AppModule(val app: Application) {

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

    @Provides
    @Singleton
    fun provideNetworkInfo(): NetworkConnectivity = NetworkConnectivity(app)

    @Provides
    fun providePostRepository(apiInterface: ApiInterface,postsDao: PostsDao,networkConnectivity: NetworkConnectivity):PostsRepository{
      return PostsRepository(apiInterface,postsDao,networkConnectivity)
    }

    @Provides
    fun providePostListViewModelFactory(postsRepository: PostsRepository):PostListViewModelFactory {
        return PostListViewModelFactory(postsRepository)
    }
}