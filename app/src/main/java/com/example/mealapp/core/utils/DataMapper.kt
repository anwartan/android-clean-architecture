package com.example.mealapp.core.utils

import com.example.mealapp.core.data.source.local.entity.MealEntity
import com.example.mealapp.core.data.source.remote.response.MealResponse
import com.example.mealapp.core.domain.model.Meal

object DataMapper {
    fun mapResponsesToEntities(input: List<MealResponse>): List<MealEntity> {
        val mealList = ArrayList<MealEntity>()
        input.map {
            val meal = MealEntity(
                idMeal = it.idMeal,
                strArea = it.strArea,
                strCategory = it.strCategory,
                strMeal = it.strMeal,
                strInstructions = it.strInstructions,
                strMealThumb = it.strMealThumb,
                strTags = it.strTags,
                isFavorite = false
            )
            mealList.add(meal)
        }
        return mealList
    }
    fun mapEntitiesToDomain(input: List<MealEntity>): List<Meal> =
        input.map {
            Meal(
                idMeal = it.idMeal,
                strMeal = it.strMeal,
                strMealThumb = it.strMealThumb,
                strInstructions = it.strInstructions,
                strTags = it.strTags,
                strCategory = it.strCategory,
                strArea = it.strArea,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: Meal) = MealEntity(
        idMeal = input.idMeal,
        strMeal = input.strMeal,
        strMealThumb = input.strMealThumb,
        strInstructions = input.strInstructions,
        strTags = input.strTags,
        strCategory = input.strCategory,
        strArea = input.strArea,
        isFavorite = input.isFavorite
    )
}
