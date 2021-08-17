package com.example.mealapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.mealapp.core.data.Resource
import com.example.mealapp.core.domain.model.Meal
import com.example.mealapp.core.domain.repository.IMealRepository

class MealInteractor(private val mealRepository: IMealRepository): MealUsecase {
    override fun getAllMeal(): LiveData<Resource<List<Meal>>> {
        return mealRepository.getAllMeal()
    }

    override fun getFavoriteMeal(): LiveData<List<Meal>> {
        return mealRepository.getFavoriteMeal()
    }

    override fun setFavoriteMeal(meal: Meal, state: Boolean) {
        mealRepository.setFavoriteMeal(meal,state)
    }
}