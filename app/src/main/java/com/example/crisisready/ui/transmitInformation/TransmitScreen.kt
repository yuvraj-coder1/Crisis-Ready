package com.example.crisisready.ui.transmitInformation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crisisready.ui.viewmodel.UserViewModel

@SuppressLint("MissingPermission")
@Composable
fun TransmitScreen(viewModel: UserViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomDropdownMenu(
            modifier = Modifier.padding(vertical = 8.dp),
            placeholder = "Select Type",
            onValueChange = {
                viewModel.onTypeChange(it)
            },
            options = listOf("Danger", "Safe", "others")
        )
        OutlinedTextField(
            value = viewModel.text.value,
            onValueChange = { viewModel.text.value = it },
            readOnly = viewModel.type.value != "others",
        )
        Button(onClick = {
            viewModel.updateStatus()
        }) {
            Text("Send Status")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropdownMenu(
    placeholder: String,
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    options: List<String>
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedOptionText by rememberSaveable { mutableStateOf(value) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        OutlinedTextField(
            value = selectedOptionText,
            onValueChange = { selectedOptionText = it },
            placeholder = { Text(text = placeholder) },
            readOnly = true, modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                        onValueChange(selectionOption)
                    },
                    text = { Text(selectionOption) }
                )
            }
        }
    }
}
