package com.example.crisisready.ui.homeScreen

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.view.ViewGroup
import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.crisisready.R
import com.example.crisisready.data.WEB_API_KEY
import com.example.crisisready.model.Current
import com.example.crisisready.ui.map.MapContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSafetyTipClicked: () -> Unit = {},
    onDoDontsClicked: () -> Unit = {},
    onEmergencyContactClicked: () -> Unit = {},
    onMapClicked: () -> Unit
) {
    Scaffold(
        topBar = { HomeScreenTopBar() }
    ) {
        HomeScreenContent(
            modifier = Modifier.padding(it),
            onSafetyTipClicked = onSafetyTipClicked,
            onDoDontsClicked = onDoDontsClicked,
            onEmergencyContactClicked = onEmergencyContactClicked,
            onMapClicked = onMapClicked
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
) {
    var showAlert by rememberSaveable { mutableStateOf(false) }
    if (showAlert) {
        AlertDialog(
            title = { Text(text = stringResource(R.string.log_out)) },
            text = { Text(text = stringResource(R.string.are_you_sure_you_want_to_log_out)) },
            onDismissRequest = { showAlert = false },
            confirmButton = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.yes))
                }
            },
            dismissButton = {
                TextButton(onClick = { showAlert = false }) {
                    Text(text = stringResource(R.string.no))
                }
            }
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
                contentDescription = stringResource(R.string.notification)
            )
        },
        navigationIcon = {
            val ctx = LocalContext.current

            androidx.compose.material3.Icon(
                imageVector = Icons.Default.SettingsPower,
                tint = Color.Red,
                contentDescription = stringResource(id = R.string.log_out),
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
    onEmergencyContactClicked: () -> Unit = {},
    onMapClicked: () -> Unit = {}
) {
    val viewModel: HomeScreenViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.loadCurrentWeather(WEB_API_KEY, "Bangalore")
    }
    val weatherResponse = viewModel.weatherResponse.value?.current ?: Current()
    val location = "Bangalore"
    val temperature = weatherResponse.temp_c
    val humidity = weatherResponse.humidity
    val wind = weatherResponse.wind_mph
    val weather = weatherResponse.condition.text
    val pressure = weatherResponse.pressure_mb
    val icon = weatherResponse.condition.icon
    var isUserSafe = true
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(Color(24, 61, 77, 255))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(bottom = 16.dp),
            ) {
                Text(
                    text = location,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(0.5f)
                    ) {
                        Image(
//                            painter = painterResource(id = R.drawable.partially_cloudy),
                            painter = rememberAsyncImagePainter("https://$icon"),
                            contentDescription = weather,
                            modifier = Modifier.size(50.dp)
                        )

//                        AsyncImage(model = icon, contentDescription = )
                        Text(
                            text = weather,
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Text(
                        text = "$temperature °C",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Humidity: $humidity %",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White
                        )
                        Text(
                            text = "Wind: $wind mph",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White
                        )
                        Text(
                            text = "Pressure: $pressure mb",
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White
                        )

                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (!isUserSafe) {
            Text(text = "Alerts", style = MaterialTheme.typography.titleLarge)
        }
        if (isUserSafe) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.elevatedCardElevation(4.dp),
            )
            {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text(
                        text = "Did You Know?",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = disasterTips.random(), style = MaterialTheme.typography.titleMedium)
                }
            }
        } else {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                colors = CardDefaults.cardColors(Color.Red)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Button(
                        onClick =
                        onMapClicked
                    ) {
                        Text(text = "View Map")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Dashboard", style = MaterialTheme.typography.titleLarge)
        FlowRow(modifier = Modifier.fillMaxWidth()) {
            DashboardItem(
                icon = Icons.Default.HealthAndSafety,
                text = stringResource(R.string.safety_tips),
                modifier = Modifier.weight(1f),
                onClick = onSafetyTipClicked
            )
            DashboardItem(
                icon = Icons.Default.Checklist,
                text = stringResource(R.string.do_s_don_ts),
                modifier = Modifier.weight(1f),
                onClick = onDoDontsClicked
            )
            DashboardItem(
                icon = Icons.Default.Phone,
                text = stringResource(R.string.contact_info),
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
//    HomeScreen()
}