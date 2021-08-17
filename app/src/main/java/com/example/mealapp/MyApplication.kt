package com.example.mealapp

import android.app.Application
import com.example.mealapp.core.di.CoreComponent
import com.example.mealapp.core.di.DaggerCoreComponent
import com.example.mealapp.di.AppComponent
import com.example.mealapp.di.DaggerAppComponent

class MyApplication :Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
    override fun onCreate() {
        super.onCreate()
        //using koin

    }
}