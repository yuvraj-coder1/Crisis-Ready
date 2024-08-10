package com.example.crisisready.ui.doDonts

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DoDontsViewModel:ViewModel() {
    private val _selected = MutableStateFlow<String>("")
    val selected = _selected.asStateFlow()
    fun setSelected(value:String){
        _selected.value = value
        Log.d("selected",selected.value)
    }

}