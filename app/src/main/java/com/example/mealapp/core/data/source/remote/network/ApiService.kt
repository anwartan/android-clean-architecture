package com.example.mealapp.core.data.source.remote.network

import com.example.mealapp.core.data.source.remote.response.ListMealResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    fun getList(): Call<ListMealResponse>
}