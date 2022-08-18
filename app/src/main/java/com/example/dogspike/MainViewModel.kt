package com.example.dogspike

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel() : ViewModel() {

    private val _dogsUrls = MutableStateFlow(listOf<String>())
    val dogsUrls: StateFlow<List<String>> = _dogsUrls

    private var fetchJob: Job? = null

    init {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                //TODO: Replace this with data from the server
                val dogs = mutableListOf(
                    "https://images.dog.ceo/breeds/poodle-miniature/n02113712_1077.jpg",
                    "https://images.dog.ceo/breeds/spaniel-cocker/n02102318_3700.jpg",
                    "https://images.dog.ceo/breeds/stbernard/n02109525_3346.jpg",
                    "https://images.dog.ceo/breeds/chihuahua/n02085620_3928.jpg",
                    "https://images.dog.ceo/breeds/shihtzu/n02086240_415.jpg",
                    "https://images.dog.ceo/breeds/retriever-chesapeake/n02099849_3346.jpg",
                    "https://images.dog.ceo/breeds/spaniel-japanese/n02085782_1774.jpg",
                    "https://images.dog.ceo/breeds/germanshepherd/n02106662_19791.jpg",
                    "https://images.dog.ceo/breeds/terrier-dandie/n02096437_1656.jpg"
                )
                _dogsUrls.update {
                    dogs
                }
            } catch (ioe: IOException) {
                //TODO: Add logic to handle errors
            }
        }
    }
}