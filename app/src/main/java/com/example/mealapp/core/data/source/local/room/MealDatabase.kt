package com.example.mealapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mealapp.core.data.source.local.entity.MealEntity

@Database(entities = [MealEntity::class],version = 2,exportSchema = false)
abstract class MealDatabase:RoomDatabase() {
    abstract fun mealDao():MealDao

//    companion object{
//        @Volatile
//        private var INSTANCE: MealDatabase? = null
//        fun getInstance(context: Context): MealDatabase =
//            INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MealDatabase::class.java,
//                    "Meal.db"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//    }
}