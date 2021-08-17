package com.example.mealapp.di

import com.example.mealapp.core.domain.usecase.MealInteractor
import com.example.mealapp.core.domain.usecase.MealUsecase
import com.example.mealapp.detail.DetailViewModel
import com.example.mealapp.favorite.FavoriteViewModel
import com.example.mealapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MealUsecase> {
        MealInteractor(
            get()
        )
    }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}