package com.example.crisisready.ui.adminHome

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class adminHomeScreenViewModel:ViewModel() {
   private val _disasterList = MutableStateFlow(listOf(disaster()))
    private val _selectedLocation = MutableStateFlow("")
    private val _selectedDisaster = MutableStateFlow("")
    val selectedLocation = _selectedLocation.asStateFlow()
    val selectedDisaster = _selectedDisaster.asStateFlow()
    val disasterList = _disasterList.asStateFlow()
    fun addDisaster(disaster: disaster){
        _disasterList.value += disaster
    }
    fun removeDisaster(disaster: disaster){
        _disasterList.value -= disaster
    }
    fun updateSelectedLocation(location: String){
        _selectedLocation.value = location
    }
    fun updateSelectedDisaster(disaster: String) {
        _selectedDisaster.value = disaster
    }
}

data class disaster(
    val disasterName:String="",
    val disasterLocation:String="",
)