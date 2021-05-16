package com.example.api

import com.example.api.models.entities.UserCreds
import com.example.api.models.requests.SignupRequest
import com.example.api.services.ConduitApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random

class CoduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `Get articles`(){
        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Get articles by author`(){
        runBlocking {
            val articles = conduitClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Post request response`(){
        val userCreds = UserCreds(
            email = "testmail${Random.nextInt(999, 9999)}@test.com",
            password = "${Random.nextInt(99999999, 999999999)}",
            username = "rand_user_${Random.nextInt(99, 999)}"
        )
        val signupRequest = SignupRequest(userCreds = userCreds)
        runBlocking{
            val response = conduitClient.api.signupUsers(signupRequest)
            assertEquals(userCreds.username, response.body()?.user?.username)
        }
    }

}