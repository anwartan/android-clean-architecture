package com.example.mealapp.core.data.source.local

import androidx.lifecycle.LiveData
import com.example.mealapp.core.data.source.local.entity.MealEntity
import com.example.mealapp.core.data.source.local.room.MealDao

class LocalDataSource (private val mealDao: MealDao){

//    companion object{
//        private var instance: LocalDataSource?=null
//
//        fun getInstance(mealDao: MealDao):LocalDataSource=
//            instance?: synchronized(this){
//                instance?:LocalDataSource(mealDao)
//            }
//
//    }
    fun getAllMeal(): LiveData<List<MealEntity>> = mealDao.getAllMeal()

    fun insertMeal(mealList: List<MealEntity>) = mealDao.insertMeal(mealList)

    fun getFavoriteMeal():LiveData<List<MealEntity>>{
        return mealDao.getFavoriteMeal()
    }

    fun setFavoriteMeal(meal: MealEntity, newState:Boolean){
        meal.isFavorite=newState
        mealDao.updateFavoriteMeal(meal)
    }
}