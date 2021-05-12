package com.app.test.data.repository

import com.app.test.data.remote.api.APIService
import com.app.test.model.Photo
import com.app.test.model.State
import com.app.test.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class DataRepository @Inject constructor(private val apiService: APIService) {

    /**
     * Fetched the photos from network and show
     */
    fun getAllImages(): Flow<State<List<Photo>>> {
        return object : NetworkBoundRepository<List<Photo>>() {
            override suspend fun fetchFromRemote(): Response<List<Photo>> = apiService.getPhotos()

        }.asFlow().flowOn(Dispatchers.IO)
    }

    /**
     * Fetched the users from network and show
     */
    fun getAllUsers(): Flow<State<List<User>>> {
        return object : NetworkBoundRepository<List<User>>() {
            override suspend fun fetchFromRemote(): Response<List<User>> = apiService.getUsers()

        }.asFlow().flowOn(Dispatchers.IO)
    }
}