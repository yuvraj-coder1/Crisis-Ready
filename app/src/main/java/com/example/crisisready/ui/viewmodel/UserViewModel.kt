package com.example.crisisready.ui.viewmodel

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.crisisready.MainActivity
import com.example.crisisready.R
import com.example.crisisready.data.NotificationBody
import com.example.crisisready.data.SendMessageDto
import com.example.crisisready.data.api.FcmApi
import com.example.crisisready.data.repository.UserRepository
import com.google.firebase.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.messaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository,
    private val api: FcmApi
) : ViewModel() {

    init {
        viewModelScope.launch {
            Firebase.messaging.subscribeToTopic("Alert").await()
        }
    }

    fun fetchAndSaveToken() {
        viewModelScope.launch {
            val token = Firebase.messaging.token.await()
            Log.d("TAG", "fetchAndSaveToken: $token")
            repository.saveToken(token)
        }
//        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                val token = task.result
//                token?.let {  }
//            }
//        }
    }

    fun sendNotification(context: Context) {
//        val title = "Test Notification"
//        val message = "This is a test notification sent from the app."
//        Log.d("TAG", "sendNotification: check1")
//        val notificationBuilder = NotificationCompat.Builder(context, "default_channel_id")
//            .setSmallIcon(R.drawable.baseline_notifications_24)
//            .setContentTitle(title)
//            .setContentText(message)
//            .setAutoCancel(true)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setContentIntent(getPendingIntent(context))
//
//        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(0, notificationBuilder.build())
        viewModelScope.launch {
            val messageDto = SendMessageDto(
                to = null,
                notification = NotificationBody(
                    title = "Test Notification",
                    body = "This is a test notification sent from the app."
                )
            )
            try {
                api.broadCast(messageDto)
            } catch (e: HttpException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun getPendingIntent(context: Context): PendingIntent {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        return PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )
    }
}