package com.example.mealapp.favorite

import androidx.lifecycle.ViewModel
import com.example.mealapp.core.domain.usecase.MealUsecase

class FavoriteViewModel (mealUsecase: com.example.mealapp.core.domain.usecase.MealUsecase): ViewModel() {
    val favoriteMeal = mealUsecase.getFavoriteMeal()
}
