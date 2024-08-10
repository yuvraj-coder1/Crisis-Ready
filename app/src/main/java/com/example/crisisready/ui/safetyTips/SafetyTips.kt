package com.example.crisisready.ui.safetyTips

import android.content.Intent
import android.graphics.ColorFilter
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.rememberAsyncImagePainter
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SafetyTipsTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = { Text(text = "Safety Tips") })
}

@Composable
fun SafetyTipsScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { SafetyTipsTopBar() }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            safetyTipsList.forEach {
//                YouTubeVideoRow(title = it.value, videoId = it.key)
                SafetyVideoList(disaster = it.key, disasterVideos = it.value)
                Spacer(modifier = Modifier.height(10.dp))
            }
//        YouTubeVideoRow(videoId = "B9qR2e3xyJo", title = "What To Do Before & During A Cyclone ?")
        }
    }
}

@Composable
fun SafetyVideoList(
    modifier: Modifier = Modifier,
    disaster: String,
    disasterVideos: Map<String, String>
) {
    Text(
        text = disaster.uppercase(),
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(10.dp))
    HorizontalDivider()
    Spacer(modifier = Modifier.height(10.dp))
    disasterVideos.forEach() {
        YouTubeVideoRow(title = it.value, videoId = it.key)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun SafetyTip(modifier: Modifier = Modifier, title: String, videoId: String) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        YoutubeScreen(videoId = "B9qR2e3xyJo", modifier = Modifier.weight(0.5f))
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = title, modifier = Modifier.weight(0.5f))

    }
}

@Composable
fun YouTubeVideoRow(videoId: String, title: String) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=$videoId")
                )
                context.startActivity(intent)
            }
    ) {
        // Thumbnail
        Box(
            modifier = Modifier
                .weight(0.4f)
                .height(80.dp)
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(8.dp)),

            ) {
            Image(
                painter = rememberAsyncImagePainter("https://img.youtube.com/vi/$videoId/0.jpg"),
                contentDescription = "YouTube Thumbnail",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,

                )
            // Play button
            Image(
                painter = rememberAsyncImagePainter("https://img.icons8.com/?size=100&id=9978&format=png&color=FA5252"),
                contentDescription = "Play button",
                modifier = Modifier
                    .size(50.dp)
                    .align(
                        androidx.compose.ui.Alignment.Center
                    )
            )
        }

        // Title
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .alignByBaseline()
                .weight(0.6f)
        )
    }
}

@Composable
fun YoutubeScreen(
    videoId: String,
    modifier: Modifier
) {
    val ctx = LocalContext.current
    AndroidView(modifier = modifier, factory = {
        val view = YouTubePlayerView(it)
        val fragment = view.addYouTubePlayerListener(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            }
        )
        view
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SafetyTipsPreview(modifier: Modifier = Modifier) {
    SafetyTipsScreen()
}