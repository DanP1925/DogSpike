package com.example.dogspike.data

import com.example.dogspike.data.remote.GetDogsResponse
import javax.inject.Inject

class DogsRepository @Inject constructor(
    private val dogsDataSource: DogsDataSource
) {

    suspend fun getDogsUrls(): List<String> = dogsDataSource.getDogsUrls()

}