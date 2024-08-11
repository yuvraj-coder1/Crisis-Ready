package com.example.crisisready.data.repository

import com.example.crisisready.data.api.WeatherApi
import com.example.crisisready.model.WeatherResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton


@Singleton
class NetworkWeathersRepository(
    private val weatherApi: WeatherApi
)  {
    suspend fun getWeather(apiKey: String, location: String): WeatherResponse {
        return weatherApi.getWeather(apiKey = apiKey, location = location)
    }
}