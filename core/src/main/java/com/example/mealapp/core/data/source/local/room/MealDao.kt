package com.example.mealapp.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mealapp.core.data.source.local.entity.MealEntity

@Dao
interface MealDao {

    @Query("SELECT * FROM meal")
    fun getAllMeal():LiveData<List<MealEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(meals:List<MealEntity>)

    @Query("SELECT * FROM meal where isFavorite = 1")
    fun getFavoriteMeal(): LiveData<List<MealEntity>>

    @Update
    fun updateFavoriteMeal(meal: MealEntity)


}