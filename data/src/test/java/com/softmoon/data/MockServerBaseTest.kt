package com.softmoon.data

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import java.io.File

abstract class MockServerBaseTest {
    private lateinit var mockServer: MockWebServer

    @Before
    open fun setUpServer() {
        this.configureMockServer()
    }

    @After
    open fun tearDownServer() {
        this.stopMockServer()
    }

    abstract fun isMockServerEnabled(): Boolean

    open fun configureMockServer() {
        if (isMockServerEnabled()) {
            mockServer = MockWebServer()
            mockServer.start()
        }
    }

    open fun stopMockServer() {
        if (isMockServerEnabled()) {
            mockServer.shutdown()
        }
    }

    open fun mockHttpResponse(fileName: String, responseCode: Int) =
        mockServer.enqueue(MockResponse().setResponseCode(responseCode).setBody(getJson(fileName)))

    open fun mockHttpResponse(responseCode: Int) =
        mockServer.enqueue(MockResponse().setResponseCode(responseCode))

    private fun getJson(path: String): String {
        val uri = this.javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

    fun provideTestApolloService(): ApolloClient {
        return ApolloClient
            .builder()
            .serverUrl(mockServer.url(""))
            .okHttpClient(
                OkHttpClient
                    .Builder()
                    .build()
            )
            .build()
    }
}