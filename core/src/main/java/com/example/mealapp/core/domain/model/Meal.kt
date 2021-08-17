package com.example.mealapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meal(
    var idMeal:String,
    var strMeal:String,
    var strCategory:String,
    var strArea:String,
    var strInstructions:String,
    var strMealThumb:String,
    var strTags:String,
    var isFavorite:Boolean

):Parcelable