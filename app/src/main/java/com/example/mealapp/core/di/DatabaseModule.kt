package com.example.mealapp.core.di

import android.content.Context
import androidx.room.Room
import com.example.mealapp.core.data.source.local.room.MealDao
import com.example.mealapp.core.data.source.local.room.MealDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MealDatabase = Room.databaseBuilder(
        context,
        MealDatabase::class.java, "Meal.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: MealDatabase): MealDao = database.mealDao()
}