package com.example.mealapp.favorite

import androidx.lifecycle.ViewModel
import com.example.mealapp.core.domain.usecase.MealUsecase

class FavoriteViewModel (mealUsecase: MealUsecase): ViewModel() {
    val favoriteMeal = mealUsecase.getFavoriteMeal()
}
