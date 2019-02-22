package com.example.mi_post.data.source

import com.example.mi_post.data.model.Post
import com.example.mi_post.data.source.local.PostsDao
import com.example.mi_post.data.source.remote.ApiInterface
import com.example.mi_post.utils.NetworkConnectivity
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by Festus Kiambi on 2/22/19.
 */
class PostRepositoryTest {

    val apiInterface: ApiInterface = mockk()
    val postsDao: PostsDao = mockk(relaxed = true)
    val networkConnectivity: NetworkConnectivity = mockk()

    val postsRepository = PostsRepository(apiInterface, postsDao,networkConnectivity)

    fun getPost(
        userId: Int = 1,
        id: Int = 1,
        title: String = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        body: String = "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit" +
                " molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
    ) = Post(
        userId,
        id,
        title,
        body
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        clearMocks()
    }

    @Test
    fun `on get posts from api successfully`() = runBlocking {

        val postsLists = listOf(getPost(), getPost(), getPost())

        coEvery { apiInterface.getPosts().await().body() } returns postsLists

        val result = postsRepository.getPostsFromApi()

        coVerify { apiInterface.getPosts() }
         verify { postsDao.insertPost(getPost()) }
        assertEquals(result, postsLists)
    }

    @Test
    fun `on get posts from local db succesfully`() = runBlocking {

        val postsLists = listOf(getPost(), getPost(), getPost())

        coEvery { postsDao.queryPosts().value } returns postsLists

        val result = postsRepository.getPostsFromDb()

        coVerify { postsDao.queryPosts() }
        assertEquals(result, postsLists)

    }

    @Test
    fun `on get posts successfully with network`() = runBlocking {
        val postsLists = listOf(getPost(), getPost(), getPost())

        every { networkConnectivity.isConnected() } returns true
        coEvery { apiInterface.getPosts().await().body() } returns postsLists

        val result = postsRepository.getPosts()

        coVerify { apiInterface.getPosts() }
        verify { networkConnectivity.isConnected() }
        assertEquals(result,postsLists)

    }

    @Test
    fun `on get posts successfully without network`() = runBlocking {
        val postsLists = listOf(getPost(), getPost(), getPost())

        every { networkConnectivity.isConnected() } returns false
        coEvery { postsDao.queryPosts().value } returns postsLists

        val result = postsRepository.getPosts()

        coVerify { postsDao.queryPosts() }
        verify { networkConnectivity.isConnected() }
        assertEquals(result,postsLists)

    }
}