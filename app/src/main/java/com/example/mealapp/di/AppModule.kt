package com.example.mealapp.di

import com.example.mealapp.core.domain.usecase.MealInteractor
import com.example.mealapp.core.domain.usecase.MealUsecase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(mealInteractor: MealInteractor): MealUsecase

}