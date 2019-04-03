package com.example.geolocation

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    fun getClient(): Service {
        val httpClient = OkHttpClient.Builder()

        val builder = Retrofit.Builder()
            .baseUrl("your_server_url")
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder
            .client(httpClient.build())
            .build()

        return retrofit.create(Service::class.java)
    }
}