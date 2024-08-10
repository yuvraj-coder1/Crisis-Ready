package com.example.crisisready.data.api

import com.example.crisisready.data.SendMessageDto
import retrofit2.http.Body
import retrofit2.http.POST

interface FcmApi {
    @POST("/send")
    suspend fun sendMessage(
        @Body body:SendMessageDto
    )

    @POST("/broadCast")
    suspend fun broadCast(
        @Body body:SendMessageDto
    )
}