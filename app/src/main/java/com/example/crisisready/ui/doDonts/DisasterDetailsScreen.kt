package com.example.crisisready.ui.doDonts

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.crisisready.ui.navigation.DisasterDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisasterDetailsScreenTopBar(modifier: Modifier = Modifier,disaster: String) {
    CenterAlignedTopAppBar(title = { Text(text = disaster) })
}

@Composable
fun DisasterDetailsScreen(modifier: Modifier = Modifier,disaster: String) {
    Scaffold(
        topBar = { DisasterDetailsScreenTopBar(disaster = disaster) }
    ) {
        DisasterDetailsContent(modifier = Modifier.padding(it),disaster = disaster)
    }
}

@Composable
fun DisasterDetailsContent(modifier: Modifier = Modifier, disaster: String) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Log.d("disaster", disaster)
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            HorizontalDivider()
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Do's",
                    color = Color.Green,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
//            Log.d("disaster", disasterGuidelines[disaster]?.get("Do's").toString())
            Spacer(modifier = Modifier.height(10.dp))
            disasterGuidelines[disaster]?.get("Do's")
                ?.let { InfoList(iconColor = Color.Green, knowledge = it) }
            InfoList(iconColor = Color.Green, knowledge = disasterGuidelines[disaster]?.get("Do's"))
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Don'ts",
                    color = Color.Red,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,

                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            disasterGuidelines[disaster]?.get("Don'ts")
                ?.let { InfoList(iconColor = Color.Red, knowledge = it) }
            HorizontalDivider()
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Before", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(10.dp))
            disasterGuidelines[disaster]?.get("Before")
                ?.let { InfoList(iconColor = Color.Green, knowledge = it) }

            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "During", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(10.dp))
            disasterGuidelines[disaster]?.get("During")
                ?.let { InfoList(iconColor = Color.Green, knowledge = it) }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "After", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(10.dp))
            disasterGuidelines[disaster]?.get("After")
                ?.let { InfoList(iconColor = Color.Green, knowledge = it) }
        }
    }
}

@Composable
fun InfoList(modifier: Modifier = Modifier, iconColor: Color, knowledge: List<Int>?) {
    knowledge?.forEach() {
        DisplayInfo(iconColor = iconColor, content = stringResource(id =  it))
    }
}

@Composable
fun DisplayInfo(modifier: Modifier = Modifier, iconColor: Color, content: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        androidx.compose.material3.Icon(
            imageVector = Icons.Default.RadioButtonChecked,
            contentDescription = null,
            tint = iconColor
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = content)
    }
}