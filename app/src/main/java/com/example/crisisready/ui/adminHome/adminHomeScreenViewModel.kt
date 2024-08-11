package com.example.crisisready.ui.adminHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.crisisready.data.NotificationBody
import com.example.crisisready.data.SendMessageDto
import com.example.crisisready.data.api.FcmApi
import com.example.crisisready.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class adminHomeScreenViewModel @Inject constructor(
    private val api: FcmApi,
) :
    ViewModel() {
    private val _disasterList = MutableStateFlow<List<disaster>>(emptyList())
    private val _selectedLocation = MutableStateFlow("")
    private val _selectedDisaster = MutableStateFlow("")
    val selectedLocation = _selectedLocation.asStateFlow()
    val selectedDisaster = _selectedDisaster.asStateFlow()
    val disasterList = _disasterList.asStateFlow()
    fun addDisaster(disaster: disaster) {
        _disasterList.value += disaster
    }

    fun removeDisaster(disaster: disaster) {
        _disasterList.value -= disaster
    }

    fun updateSelectedLocation(location: String) {
        _selectedLocation.value = location
    }

    fun updateSelectedDisaster(disaster: String) {
        _selectedDisaster.value = disaster
    }

    fun sendNotification() {
        viewModelScope.launch {
            val messageDto = SendMessageDto(
                to = null,
                notification = NotificationBody(
                    title = "Disaster Alert",
                    body = "This is an alert for ${selectedDisaster.value} at ${selectedLocation.value}"
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

data class disaster(
    val disasterName: String = "",
    val disasterLocation: String = "",
)