package com.example.mealapp.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealapp.core.di.Injection
import com.example.mealapp.core.domain.usecase.MealUsecase
import com.example.mealapp.detail.DetailViewModel
import com.example.mealapp.favorite.FavoriteViewModel
import com.example.mealapp.home.HomeViewModel

class ViewModelFactory private constructor(private val mealUsecase: MealUsecase):ViewModelProvider.NewInstanceFactory() {

//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory =
//            instance
//                ?: synchronized(this) {
//                    instance
//                        ?: ViewModelFactory(
//                            Injection.provideTourismUseCase(
//                                context
//                            )
//                        )
//                }
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(mealUsecase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mealUsecase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(mealUsecase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}