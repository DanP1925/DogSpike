package com.example.dogspike

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogspike.data.DogsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: DogsRepository
) : ViewModel() {

    private val _dogsUrls = MutableStateFlow(listOf<String>())
    val dogsUrls: StateFlow<List<String>> = _dogsUrls

    private var fetchJob: Job? = null

    init {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val dogs = repository.getDogsUrls()
                _dogsUrls.update {
                    dogs
                }
            } catch (ioe: IOException) {
                //TODO: Add logic to handle errors
            }
        }
    }
}