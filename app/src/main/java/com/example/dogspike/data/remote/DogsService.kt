package com.example.dogspike.data.remote

import retrofit2.http.GET

interface DogsService {

    @GET("breeds/image/random/50")
    suspend fun getDogs(): GetDogsResponse

}