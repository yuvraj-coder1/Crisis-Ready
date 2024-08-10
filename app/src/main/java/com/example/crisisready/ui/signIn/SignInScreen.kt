package com.example.crisisready.ui.signIn

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crisisready.R

@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    val images = listOf(
        R.drawable.edudisaster,
        R.drawable.disaster_communication,
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    val threshold = 50.dp
                    if (dragAmount.dp < -threshold && currentIndex < images.size - 1) {
                        currentIndex = (currentIndex + 1) % images.size
                    } else if (dragAmount.dp > threshold && currentIndex > 0) {
                        currentIndex = (currentIndex - 1) % images.size
                    } else {
                        // Do nothing eat 5 star
                    }
                }
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .size(500.dp)
        )

        // Indicator dots
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            repeat(images.size) { index ->
                Dot(
                    isSelected = index == currentIndex,
                    modifier = Modifier.size(12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (currentIndex == 0) {
                Text(
                    text = "Disaster Preparedness Education",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    text = "Reliable Emergency Communication",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }



        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onSignInClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "Get Started")
        }
    }

//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Button(onClick = onSignInClick) {
//            Text(text = "Sign in")
//        }
//    }
}

@Composable
fun Dot(isSelected: Boolean, modifier: Modifier = Modifier) {
    val color =
        if(isSystemInDarkTheme()) {
            if (isSelected)
                Color.White
            else
                Color.Gray
        } else {
            if (isSelected)
                Color.Gray
            else
                Color.White
        }

    Box(
        modifier = modifier
            .size(16.dp)
            .border(
                width = 0.5.dp, // Adjust the width of the border as needed
                color = Color.Black, // Adjust the color of the border as needed
                shape = CircleShape
            )
            .background(color = color, shape = CircleShape)
            .graphicsLayer {
                alpha = if (isSelected) 1f else 0.5f
            }
    )
}