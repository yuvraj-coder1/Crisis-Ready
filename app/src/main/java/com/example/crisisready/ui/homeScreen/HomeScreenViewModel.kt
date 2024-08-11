package com.example.crisisready.ui.homeScreen

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crisisready.data.repository.NetworkWeathersRepository
import com.example.crisisready.model.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val weatherRepository: NetworkWeathersRepository
):ViewModel() {
    var weatherResponse = mutableStateOf<WeatherResponse?>(null)
    fun loadCurrentWeather(apiKey: String, location: String) {
        viewModelScope.launch {
            weatherResponse.value = weatherRepository.getWeather(apiKey, location)
            Log.d("Tag", weatherResponse.value!!.current.condition.icon.toString())
        }
    }
}