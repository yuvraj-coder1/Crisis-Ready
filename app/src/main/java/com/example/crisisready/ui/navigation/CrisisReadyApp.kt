package com.example.crisisready.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.crisisready.ui.doDonts.DisasterDetailsScreen
import com.example.crisisready.ui.doDonts.DoDontsScteen
import com.example.crisisready.ui.homeScreen.HomeScreen
import com.example.crisisready.ui.signIn.UserData

@Composable
fun CrisisReadyApp(modifier: Modifier = Modifier, userData: UserData?, onSignOut: () -> Unit = {}) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onDoDontsClicked = {navController.navigate(DoDonts)}
            )
        }
        composable<DoDonts> {
            DoDontsScteen(onclick = { navController.navigate(DisasterDetails(it)) })
        }
        composable<DisasterDetails> {
            val args = it.toRoute<DisasterDetails>()
            DisasterDetailsScreen(disaster = args.disaster)
        }
    }
}