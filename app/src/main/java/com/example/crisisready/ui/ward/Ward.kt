package com.example.crisisready.ui.ward

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.crisisready.R
import com.example.crisisready.ui.doDonts.Disaster
import com.example.crisisready.ui.doDonts.naturalDisasterList


val wardList = listOf(
    (R.string.ward_a),
    (R.string.ward_b),
    (R.string.ward_c),
    (R.string.ward_d),
    (R.string.ward_e)
)
@Composable
fun Ward(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Wards",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(5.dp))
        wardList.forEach() { disaster ->
//            Disaster(name = stringResource(id = disaster,))
        }
    }
}