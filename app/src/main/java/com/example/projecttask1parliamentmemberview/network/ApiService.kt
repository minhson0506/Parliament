package com.example.projecttask1parliamentmemberview.network

import com.example.projecttask1parliamentmemberview.data.Member
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Name: Son Dang (2012177)
 * Date: 8.10.2021
 * Using Retrofit and Moshi libraries to fetch JSON data from internet
 */

//Base Url which have database
private const val BASE_URL = "https://users.metropolia.fi/~peterh/"

// Implement moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Implement retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Get database from base URL
interface ApiService {
    @GET("mps.json")
    suspend fun getProperties(): List<Member>
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}

