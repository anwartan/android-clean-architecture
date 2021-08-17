package com.example.mealapp.core.utils

import android.content.Context
import com.example.mealapp.R
import com.example.mealapp.core.data.source.remote.response.MealResponse
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context:Context) {

    private fun parsingFileToString(): String? {
        val jsonString: String
        try {
            jsonString = context.resources.openRawResource(R.raw.meal).bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
    fun loadData(): List<MealResponse> {
        val list = ArrayList<MealResponse>()
        val responseObject = JSONObject(parsingFileToString().toString())
        val listArray = responseObject.getJSONArray("meals")
        for (i in 0 until listArray.length()) {
            val course = listArray.getJSONObject(i)

            val idMeal = course.getString("idMeal")
            val strArea = course.getString("strArea")
            val strCategory = course.getString("strCategory")
            val strMeal = course.getString("strMeal")
            val strInstructions = course.getString("strInstructions")
            val strMealThumb = course.getString("strMealThumb")
            val strTags = course.getString("strTags")

            val courseResponse = MealResponse(
                idMeal = idMeal,
                strArea = strArea,
                strCategory = strCategory,
                strMeal = strMeal,
                strInstructions = strInstructions,
                strMealThumb = strMealThumb,
                strTags = strTags
            )
            list.add(courseResponse)
        }
        return list
    }
}
