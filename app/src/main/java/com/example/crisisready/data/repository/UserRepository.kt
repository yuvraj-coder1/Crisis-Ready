package com.example.crisisready.data.repository


import android.location.Location
import android.util.Log
import com.example.crisisready.data.GlobalVariables
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val messaging: FirebaseMessaging
) {

    fun updateLocation(latitude: Double, longitude: Double, text: String) {
        val user = auth.currentUser
        val userDoc = firestore.collection("users").document(user?.uid ?: "")
        //update data
        userDoc.update(
            "latitude", latitude,
            "longitude", longitude,
            "text", text
        )

    }

    fun saveToken(token: String) {
        val user = auth.currentUser
        if (user != null) {
            firestore.collection("users").whereEqualTo("email", user.email).get()
                .addOnSuccessListener {
                    if (it.documents.isNotEmpty()) {
                        val userDoc = firestore.collection("users").document(user.uid)
                        userDoc.update(
                            "fcmToken", token
                        )
                    } else {
                        val userDoc = firestore.collection("users").document(user.uid)
                        userDoc.set(
                            mapOf(
                                "email" to user.email,
                                "name" to user.displayName,
                                "fcmToken" to token,
                                "latitude" to null,
                                "longitude" to null,
                                "text" to null
                            )
                        )
                    }
                }

        } else {
            val userDoc = firestore.collection("users").document("sagkb2up9sHdIdoGMN0g")
            userDoc.set(
                mapOf(
                    "email" to "admin@gmail.com",
                    "name" to "admin",
                    "fcmToken" to token,
                    "latitude" to null,
                    "longitude" to null,
                    "text" to null
                )
            )
        }
    }

    fun fetchAndConvertData() {

        // Fetch data from the 'users' collection
        firestore.collection("users")
            .get()
            .addOnSuccessListener { documents ->
                // Map the documents to the custom pin structure
                val customPins = documents.map { document ->
                    CustomPin(
                        lat = document.getDouble("latitude") ?: 0.0,
                        lon = document.getDouble("longitude") ?: 0.0,
                        title = document.getString("text") ?: "Unknown",
                        color = when (document.getString("text")) {
                            "I need help" -> "mapfling"
                            "It is safe here" -> "glampinghub"
                            else -> "mapmyindia"
                        } // Assign a default color or map it from another field if needed
                    )
                }

                // Convert the list of custom pins to a JSON string
                val json = Gson().toJson(customPins)
                GlobalVariables.customPins = json
                Log.d("TAG", "fetchAndConvertData: ${json}")
                
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }
}

data class CustomPin(
    val lat: Double,
    val lon: Double,
    val title: String,
    val color: String
)