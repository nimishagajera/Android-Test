package com.app.test.data.remote.api

import com.app.test.model.Photo
import com.app.test.model.User
import retrofit2.Response
import retrofit2.http.GET
/**
 * Service to fetch track data from end point [APP_API_URL].
 */
interface APIService {

    @GET("/photos")
    suspend fun getPhotos(): Response<List<Photo>>


    @GET("/users")
    suspend fun getUsers(): Response<List<User>>

    companion object {
        const val APP_API_URL = "https://jsonplaceholder.typicode.com"
    }
}