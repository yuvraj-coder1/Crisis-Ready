package com.example.crisisready.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.crisisready.ui.contact.ContactScreen
import com.example.crisisready.ui.doDonts.DisasterDetailsScreen
import com.example.crisisready.ui.doDonts.DoDontsScreen
import com.example.crisisready.ui.homeScreen.HomeScreen
import com.example.crisisready.ui.map.MapContent
import com.example.crisisready.ui.safetyTips.SafetyTipsScreen
import com.example.crisisready.ui.signIn.UserData
import com.example.crisisready.ui.ward.WardScreen

@Composable
fun CrisisReadyApp(modifier: Modifier = Modifier, userData: UserData?, onSignOut: () -> Unit = {}) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onDoDontsClicked = { navController.navigate(DoDonts) },
                onMapClicked = { navController.navigate(Map) },
                onEmergencyContactClicked = { navController.navigate(Contact) },
                onSafetyTipClicked = { navController.navigate(SafetyTips) }
            )
        }
        composable<DoDonts> {
            DoDontsScreen(onclick = { navController.navigate(DisasterDetails(it)) })
        }
        composable<DisasterDetails> {
            val args = it.toRoute<DisasterDetails>()
            DisasterDetailsScreen(disaster = args.disaster)
        }
        composable<Map> {
            MapContent(url = "file:///android_asset/map.html")
        }
        composable<Ward> {
            WardScreen()
        }

        composable<Contact> {
            ContactScreen()
        }
        composable<SafetyTips> {
            SafetyTipsScreen()
        }
    }
}
