package com.example.crisisready.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
data object SignIn

@Serializable
data object Home

@Serializable
data object DoDonts

@Serializable
data class DisasterDetails(val disaster: String)