package com.example.dogspike.data.remote

import com.google.gson.annotations.SerializedName

class GetDogsResponse(
    @SerializedName("message") val dogsUrls: List<String>,
    @SerializedName("status") val status: String
)