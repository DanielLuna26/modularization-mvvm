package com.softmoon.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.softmoon.data.CoroutineTestRule
import com.softmoon.data.MockServerBaseTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.net.HttpURLConnection

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PostServiceImplTest: MockServerBaseTest() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = CoroutineTestRule()

    override fun isMockServerEnabled() = true

    private lateinit var service: PostService

    @Before
    fun setUp() {
        val apolloClient = provideTestApolloService()

        service = PostServiceImpl(apolloClient)
    }

    @Test
    fun `send correct data`() = runBlocking {
        mockHttpResponse("posts_response_200.json", HttpURLConnection.HTTP_OK)

        val response = service.getPosts()

        assertTrue(!response.hasErrors())
    }
}