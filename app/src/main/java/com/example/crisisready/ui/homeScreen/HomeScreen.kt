package com.example.crisisready.ui.homeScreen

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.SettingsPower
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crisisready.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSafetyTipClicked: () -> Unit = {},
    onDoDontsClicked: () -> Unit = {},
    onEmergencyContactClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = { HomeScreenTopBar() }
    ) {
        HomeScreenContent(
            modifier = Modifier.padding(it),
            onSafetyTipClicked = onSafetyTipClicked,
            onDoDontsClicked = onDoDontsClicked,
            onEmergencyContactClicked = onEmergencyContactClicked
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
) {
    var showAlert by rememberSaveable { mutableStateOf(false) }
    if(showAlert) {
        AlertDialog(
            title = { Text(text = "Log Out") },
            text = { Text(text = "Are you sure you want to log out?") },
            onDismissRequest = { showAlert = false },
            confirmButton = { TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Yes")
            }},
            dismissButton = { TextButton(onClick = { showAlert = false }) {
                Text(text = "No")
            }}
        )
    }
    CenterAlignedTopAppBar(
        modifier = modifier.padding(horizontal = 4.dp),
        title = {
            Text(stringResource(R.string.app_name))
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "notification"
            )
        },
        navigationIcon = {
            val ctx = LocalContext.current

            androidx.compose.material3.Icon(
                imageVector = Icons.Default.SettingsPower,
                tint = Color.Red,
                contentDescription = "Log Out",
                modifier = Modifier.clickable { 
                   showAlert = true
                }
            )
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier, onSafetyTipClicked: () -> Unit = {},
    onDoDontsClicked: () -> Unit = {},
    onEmergencyContactClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Alerts", style = MaterialTheme.typography.titleLarge)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            colors = CardDefaults.cardColors(Color.Green)
        )
        {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(text = "No Alerts In Your Area")
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Dashboard", style = MaterialTheme.typography.titleLarge)
        FlowRow(modifier = Modifier.fillMaxWidth()) {
            DashboardItem(
                icon = Icons.Default.HealthAndSafety,
                text = "Safety Tips",
                modifier = Modifier.weight(1f),
                onClick = onSafetyTipClicked
            )
            DashboardItem(
                icon = Icons.Default.Checklist,
                text = "Do's/Don'ts",
                modifier = Modifier.weight(1f),
                onClick = onDoDontsClicked
            )
            DashboardItem(
                icon = Icons.Default.Phone,
                text = "Contact Info",
                modifier = Modifier.weight(1f),
                onClick = onEmergencyContactClicked
            )
        }
    }
}

@Composable
fun DashboardItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .clickable { onClick() },
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = icon, contentDescription = text)
            Text(text = text, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}