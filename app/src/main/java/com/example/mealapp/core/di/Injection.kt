package com.example.mealapp.core.di

import android.content.Context
import com.example.mealapp.core.data.MealRepository
import com.example.mealapp.core.data.source.local.LocalDataSource
import com.example.mealapp.core.data.source.local.room.MealDatabase
import com.example.mealapp.core.data.source.remote.RemoteDataSource
import com.example.mealapp.core.data.source.remote.network.ApiConfig
import com.example.mealapp.core.data.source.remote.network.ApiService
import com.example.mealapp.core.domain.usecase.MealInteractor
import com.example.mealapp.core.domain.usecase.MealUsecase
import com.example.mealapp.core.utils.AppExecutors
import com.example.mealapp.core.utils.JsonHelper

object Injection {
//    fun provideRepository(context: Context): MealRepository {
//        val database = MealDatabase.getInstance(context)
//
//        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
//        val localDataSource = LocalDataSource.getInstance(database.mealDao())
//        val appExecutors = AppExecutors()
//
//        return MealRepository(remoteDataSource, localDataSource, appExecutors)
//    }
//
//    fun provideTourismUseCase(context: Context): MealUsecase {
//        val repository = provideRepository(context)
//        return MealInteractor(repository)
//    }
}