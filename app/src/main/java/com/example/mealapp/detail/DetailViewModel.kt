package com.example.mealapp.detail

import androidx.lifecycle.ViewModel
import com.example.mealapp.core.domain.model.Meal
import com.example.mealapp.core.domain.usecase.MealUsecase

class DetailViewModel(private val mealUsecase: MealUsecase): ViewModel() {
    fun setFavoriteMeal(meal: Meal, newStatus:Boolean) = mealUsecase.setFavoriteMeal(meal, newStatus)

}