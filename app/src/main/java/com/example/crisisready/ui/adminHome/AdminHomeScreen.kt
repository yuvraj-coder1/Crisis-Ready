package com.example.crisisready.ui.adminHome

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crisisready.ui.doDonts.naturalDisasterList
import com.example.crisisready.ui.homeScreen.HomeScreenTopBar


@Composable
fun AdminHomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { HomeScreenTopBar() }
    ) {
        AdminHomeScreenContent(modifier = Modifier.padding(it))
    }
}

@Composable
fun AdminHomeScreenContent(modifier: Modifier = Modifier) {

    val availableLocation = listOf(
        "Bangalore",
        "JP Nagar",
        "Jayanagar",
        "WhiteField",
        "Rajindranagar",
    )
    val availableDisaster = listOf(
        "Earthquake",
        "Flood",
        "Cyclone",
        "Landslide",
        "Tsunami",
        "Heat Wave",
        "Fire",
        "Drought",
        "Thunderstorm",
        "Forest Fire"
    )
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()

    ) {
        MyDropDownMenu(availableOptions = availableLocation)
        Spacer(modifier = Modifier.height(16.dp))
        MyDropDownMenu(availableOptions = availableDisaster)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Alert")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier, availableOptions: List<String>) {
    val interactionSource = remember { MutableInteractionSource() }
    var selectedAvailability by rememberSaveable {
        mutableStateOf(availableOptions[0])
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    Text(
        text = "Select option",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(8.dp))
    Column(modifier = modifier.fillMaxWidth()) {


        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                BasicTextField(value = selectedAvailability,
                    onValueChange = { },
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .menuAnchor(),
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    readOnly = true,
                    enabled = true,
                    singleLine = true,
                    decorationBox = @Composable { innerTextField ->
                        OutlinedTextFieldDefaults.DecorationBox(value = selectedAvailability,
                            innerTextField = innerTextField,
                            singleLine = true,
                            interactionSource = interactionSource,
                            visualTransformation = VisualTransformation.None,
                            enabled = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            contentPadding = PaddingValues(start = 16.dp),
                            container = {
                                OutlinedTextFieldDefaults.ContainerBox(
                                    enabled = true,
                                    isError = false,
                                    interactionSource = interactionSource,
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = Color(15, 46, 66, 255),
                                        unfocusedBorderColor = Color(15, 46, 66, 255),
                                        focusedTextColor = Color(15, 46, 66, 255),
                                        unfocusedTextColor = Color(15, 46, 66, 255),
                                    ),
                                    shape = MaterialTheme.shapes.medium,
                                )
                            })
                    })
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    availableOptions.forEach { selectionOption ->
                        DropdownMenuItem(text = { Text(text = selectionOption) }, onClick = {
                            selectedAvailability = selectionOption
                            expanded = false
                        })
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun AdminHomePreview(modifier: Modifier = Modifier) {
    AdminHomeScreen()
}