package com.example.dogspike.data.remote

import com.example.dogspike.data.DogsDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogsRemoteDataSource @Inject constructor(
    private val dogsService: DogsService,
    private val ioDispatcher: CoroutineDispatcher
) : DogsDataSource {

    override suspend fun getDogsUrls(): List<String> = withContext(ioDispatcher) {
        dogsService.getDogs().dogsUrls
    }

}