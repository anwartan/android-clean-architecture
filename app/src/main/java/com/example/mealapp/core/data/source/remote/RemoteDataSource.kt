package com.example.mealapp.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealapp.core.data.source.remote.network.ApiResponse
import com.example.mealapp.core.data.source.remote.network.ApiService
import com.example.mealapp.core.data.source.remote.response.ListMealResponse
import com.example.mealapp.core.data.source.remote.response.MealResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource (private val apiService: ApiService) {

//    companion object{
//        private var instance: RemoteDataSource?=null
//
//        fun getInstance(apiService: ApiService): RemoteDataSource =
//            instance?: synchronized(this){
//                instance?: RemoteDataSource(apiService = apiService)
//            }
//
//    }

    fun getAllMeal(): LiveData<ApiResponse<List<MealResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<MealResponse>>>()


        val client = apiService.getList()
        client.enqueue(object : Callback<ListMealResponse>{
            override fun onResponse(
                call: Call<ListMealResponse>,
                response: Response<ListMealResponse>
            ) {
                val dataArray = response.body()?.meals
                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }
            override fun onFailure(call: Call<ListMealResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }

        })

        return resultData
    }
}