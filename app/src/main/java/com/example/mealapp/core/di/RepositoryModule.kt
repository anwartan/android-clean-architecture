package com.example.mealapp.core.di

import com.example.mealapp.core.data.MealRepository
import com.example.mealapp.core.domain.repository.IMealRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(mealRepository: MealRepository): IMealRepository

}