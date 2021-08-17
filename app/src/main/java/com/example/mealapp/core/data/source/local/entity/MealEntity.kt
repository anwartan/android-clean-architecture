package com.example.mealapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
data class MealEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idMeal")
    var idMeal:String,

    @ColumnInfo(name = "strMeal")
    var strMeal:String,

    @ColumnInfo(name = "strCategory")
    var strCategory:String,

    @ColumnInfo(name = "strArea")
    var strArea:String,

    @ColumnInfo(name = "strInstructions")
    var strInstructions:String,

    @ColumnInfo(name = "strMealThumb")
    var strMealThumb:String,

    @ColumnInfo(name = "strTags")
    var strTags:String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite:Boolean
)