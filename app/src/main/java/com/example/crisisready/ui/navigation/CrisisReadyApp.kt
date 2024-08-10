package com.example.crisisready.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crisisready.ui.signIn.UserData

@Composable
fun CrisisReadyApp(modifier: Modifier = Modifier, userData: UserData?, onSignOut: () -> Unit = {}) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {

        }

    }
}