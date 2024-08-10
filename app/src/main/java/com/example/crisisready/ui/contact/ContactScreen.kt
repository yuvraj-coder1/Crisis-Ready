package com.example.crisisready.ui.contact

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.crisisready.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreenTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = { Text(text = stringResource(R.string.emergency_contacts)) })
}

@Composable
fun ContactScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { ContactScreenTopBar() }
    ) {
        Column(modifier = modifier
            .padding(it)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
            contactList.forEach() {
                ContactListItem(name = it.key)
            }
        }
    }

}

@Composable
fun ContactListItem(modifier: Modifier = Modifier, name: String, onclick: () -> Unit = {}) {
    var selected by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { selected = !selected },
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = name)
                if(selected)
                Icon(imageVector = Icons.Filled.ArrowDropUp, contentDescription = name)
                else
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = name)
            }
            if (selected) {
                HorizontalDivider()
                contactList[name]?.forEach() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val context = LocalContext.current

                        Text(text = "$it -")
                        TextButton(onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:$it")
//                                Log.d("tel", Uri.parse("tel:$it").toString())
                            }
                            context.startActivity(intent)
                        }) {
                            Text(text = "Call")
                        }
                    }
                }
            }

        }

    }
}