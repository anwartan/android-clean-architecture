package com.example.mealapp.di

import com.example.mealapp.core.di.CoreComponent
import com.example.mealapp.detail.DetailActivity
import com.example.mealapp.favorite.FavoriteFragment
import com.example.mealapp.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailActivity)
}