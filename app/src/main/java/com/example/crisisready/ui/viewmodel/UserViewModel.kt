package com.example.crisisready.ui.viewmodel

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.location.Location
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.crisisready.MainActivity
import com.example.crisisready.R
import com.example.crisisready.data.NotificationBody
import com.example.crisisready.data.SendMessageDto
import com.example.crisisready.data.api.FcmApi
import com.example.crisisready.data.repository.UserRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.messaging
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.IOException
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository,
    private val api: FcmApi,
    @ApplicationContext private val context: Context
) : ViewModel() {

    init {
        viewModelScope.launch {
            Firebase.messaging.subscribeToTopic("Alert").await()
        }
        repository.fetchAndConvertData()
    }

    val type = mutableStateOf("")
    val text = mutableStateOf("")

    fun onTypeChange(value: String) {
        type.value = value
        when (value) {
            "Danger" -> text.value = "I need help"
            "Safe" -> text.value = "It is safe here"
            "others" -> text.value = ""
        }
    }

    @SuppressLint("MissingPermission")
    fun updateStatus() {
        val fusedLocationClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(context)

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val latitude = location.latitude
                    val longitude = location.longitude
                    repository.updateLocation(latitude, longitude, text.value)
                    // Use the latitude and longitude values
                } else {
                    // Handle the case where location is null (e.g., location services are off)
                }
            }

    }

    fun fetchAndSaveToken() {
        viewModelScope.launch {
            val token = Firebase.messaging.token.await()
            Log.d("TAG", "fetchAndSaveToken: $token")
            repository.saveToken(token)
        }
    }

    fun sendNotification() {
        viewModelScope.launch {
            val messageDto = SendMessageDto(
                to = null,
                notification = NotificationBody(
                    title = "Test Notification",
                    body = "This is a test notification sent from the app."
                )
            )
            try {
                api.broadCast(messageDto)
            } catch (e: HttpException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}