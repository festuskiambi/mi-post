package com.example.mi_post.data.source

import com.example.mi_post.data.model.Post
import com.example.mi_post.data.source.local.PostsDao
import com.example.mi_post.data.source.remote.ApiInterface
import com.example.mi_post.utils.NetworkConnectivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 2/22/19.
 */
class PostsRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val postsDao: PostsDao,
    private val networkConnectivity: NetworkConnectivity
) {

    suspend fun getPosts(): List<Post>? {

        if (networkConnectivity.isConnected()) {
            return getPostsFromApi()
        }

        return getPostsFromDb()
    }

    suspend fun getPostsFromApi(): List<Post>? {
        val results = apiInterface.getPosts().await().body()

        if (results != null) {
            cacheResults(results)
        }
        return results
    }

    suspend fun cacheResults(results: List<Post>) = withContext(Dispatchers.IO) {
        for (result in results){
            postsDao.insertPost(result)
        }

    }

    suspend fun getPostsFromDb() = withContext(Dispatchers.IO) {
        val result = postsDao.queryPosts()

        getCachedPosts(result)
    }

    private fun getCachedPosts(result: List<Post>?): List<Post>?{
     return result

    }


}
