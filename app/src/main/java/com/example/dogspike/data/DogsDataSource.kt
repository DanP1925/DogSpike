package com.example.dogspike.data

interface DogsDataSource {

    suspend fun getDogsUrls(): List<String>

}