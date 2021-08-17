package com.example.mealapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.mealapp.core.data.Resource
import com.example.mealapp.core.data.source.local.entity.MealEntity
import com.example.mealapp.core.domain.model.Meal

interface IMealRepository {
    fun getAllMeal(): LiveData<Resource<List<Meal>>>

    fun getFavoriteMeal(): LiveData<List<Meal>>

    fun setFavoriteMeal(meal: Meal, state: Boolean)
}