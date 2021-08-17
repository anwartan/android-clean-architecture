package com.example.mealapp

import android.app.Application
import com.example.mealapp.core.di.databaseModule
import com.example.mealapp.core.di.networkModule
import com.example.mealapp.core.di.repositoryModule
import com.example.mealapp.di.useCaseModule
import com.example.mealapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        //using koin
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}