package com.example.mealapp.home

import androidx.lifecycle.ViewModel
import com.example.mealapp.core.domain.usecase.MealUsecase

class HomeViewModel(mealUsecase: MealUsecase) : ViewModel() {
    val meal = mealUsecase.getAllMeal()
}
