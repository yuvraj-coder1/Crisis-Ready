package com.example.crisisready.di

import com.example.crisisready.data.api.FcmApi
import com.example.crisisready.data.api.WeatherApi
import com.example.crisisready.data.repository.NetworkWeathersRepository
import com.example.crisisready.data.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFcmApiService(): FcmApi = Retrofit.Builder().baseUrl("http://192.168.17.224:8080")
        .addConverterFactory(GsonConverterFactory.create()).build().create()

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providesFirebaseMessaging(): FirebaseMessaging = FirebaseMessaging.getInstance()

    @Provides
    @Singleton
    fun provideUserRepository(
        auth: FirebaseAuth,
        firestore: FirebaseFirestore,
        messaging: FirebaseMessaging
    ): UserRepository {
        return UserRepository(auth, firestore, messaging)
    }

    @Provides
    @Singleton
    fun providesWeatherApi(): WeatherApi = Retrofit.Builder().baseUrl("http://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build().create()

    @Provides
    @Singleton
    fun providesWeatherRepository(weatherApi: WeatherApi): NetworkWeathersRepository {
        return NetworkWeathersRepository(weatherApi)
    }
}