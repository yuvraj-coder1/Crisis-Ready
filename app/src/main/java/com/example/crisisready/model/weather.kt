package com.example.crisisready.model

import android.health.connect.datatypes.units.Temperature
import androidx.compose.runtime.MutableState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Serializable
//data class weather(
//    @SerialName("temp_c")
//    val temperature: String,
//    @SerialName("humidity")
//    val humidity: String,
//    @SerialName("wind_mph")
//    val wind: String,
//    @SerialName("cloud")
//    val weather: String,
//    @SerialName("pressure_mb")
//    val pressure: String
//)
@Serializable
data class WeatherResponse(
    val location: Location=Location(),
    val current: Current=Current()
)

@Serializable
data class Location(
    val name: String="",
    val region: String="",
    val country: String="",
    val lat: Double=0.0,
    val lon: Double=0.0,
    val tz_id: String="",
    val localtime_epoch: Long=1,
    val localtime: String=""
)
@Serializable
data class Current(
    val temp_c: Double=0.0,
    val wind_mph: Double=0.0,
    val pressure_mb: Double=0.0,
    val humidity: Int=0,
    val condition: Condition=Condition()
)
@Serializable
data class Condition(
    val text:String = "",
    val icon:String =""
)

