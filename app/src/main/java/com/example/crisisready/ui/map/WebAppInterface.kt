package com.example.crisisready.ui.map

import android.content.Context
import android.webkit.JavascriptInterface
import com.example.crisisready.data.GlobalVariables

class WebAppInterface(private val context: Context, private val customPins: String) {

    @JavascriptInterface
    fun getCustomPins(): String{
        val customPins = GlobalVariables.customPins
        return customPins
    }
}