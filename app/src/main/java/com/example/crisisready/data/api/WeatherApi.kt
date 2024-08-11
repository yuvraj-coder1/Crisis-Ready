package com.example.crisisready.data.api

import com.example.crisisready.data.WEB_API_KEY
import com.example.crisisready.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json")
    suspend fun getWeather(
        @Query("key") apiKey: String = WEB_API_KEY,
        @Query("q") location: String = "Bangalore",
    ):WeatherResponse
}