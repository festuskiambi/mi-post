package com.example.mi_post.data.source

import com.example.mi_post.data.model.Post
import com.example.mi_post.data.source.local.PostsDao
import com.example.mi_post.data.source.remote.ApiInterface
import com.example.mi_post.utils.NetworkConnectivity
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 2/22/19.
 */
class PostsRepository @Inject constructor(
    val apiInterface: ApiInterface,
    val postsDao: PostsDao,
    val networkConnectivity: NetworkConnectivity
) {

   suspend fun getPosts(): List<Post>? {

       if (networkConnectivity.isConnected()){
           return getPostsFromApi()
       }

       return getPostsFromDb()
   }

    suspend fun getPostsFromApi(): List<Post>? {
        val results = apiInterface.getPosts().await().body()

        if (results != null) {
            for (result in results) this.postsDao.insertPost(result)
        }
        return results
    }

    suspend fun getPostsFromDb(): List<Post>? {
        return postsDao.queryPosts().value
    }


}
