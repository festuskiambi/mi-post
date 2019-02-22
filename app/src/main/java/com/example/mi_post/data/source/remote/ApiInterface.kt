package com.example.mi_post.data.source.remote

import com.example.mi_post.data.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Festus Kiambi on 2/22/19.
 */
interface ApiInterface {

    @GET("/posts")
    fun getPosts(): Deferred<Response<List<Post>>>
}