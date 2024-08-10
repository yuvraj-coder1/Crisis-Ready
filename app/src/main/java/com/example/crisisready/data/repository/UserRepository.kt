package com.example.crisisready.data.repository


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val messaging: FirebaseMessaging
) {

    fun saveToken(token: String) {
        val user = auth.currentUser
        if(user!=null){
        val userDoc = firestore.collection("users").document(user.uid)
        userDoc.set(mapOf(
            "email" to user.email,
            "name" to user.displayName,
            "fcmToken" to token
        ))
        }
        else{
            val userDoc = firestore.collection("users").document("sagkb2up9sHdIdoGMN0g")
            userDoc.set(mapOf(
                "email" to "admin@gmail.com",
                "name" to "admin",
                "fcmToken" to token
            ))
        }
    }
//    fun sendNotificationToAllUsersIndividually(tokens: List<String>, title: String, body: String) {
//        val messaging = FirebaseMessaging.getInstance()
//
//        tokens.forEach { token ->
//            val message = com.google.firebase.messaging.Message.builder()
//                .setToken(token)
//                .setNotification(
//                    com.google.firebase.messaging.Notification.builder()
//                        .setTitle(title)
//                        .setBody(body)
//                        .build()
//                )
//                .build()
//
//            messaging.send(message).addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // Successfully sent to this token
//                    println("Message sent to $token")
//                } else {
//                    // Handle failure for this token
//                    println("Failed to send message to $token")
//                }
//            }
//        }
//    }
}