package com.example.mealapp.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mealapp.core.data.source.local.LocalDataSource
import com.example.mealapp.core.data.source.remote.RemoteDataSource
import com.example.mealapp.core.data.source.remote.network.ApiResponse
import com.example.mealapp.core.data.source.remote.response.MealResponse
import com.example.mealapp.core.domain.model.Meal
import com.example.mealapp.core.domain.repository.IMealRepository
import com.example.mealapp.core.utils.AppExecutors
import com.example.mealapp.core.utils.DataMapper

class MealRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMealRepository {

//    companion object {
//        @Volatile
//        private var instance: MealRepository? = null
//
//        fun getInstance(
//            remoteData: RemoteDataSource,
//            localData: LocalDataSource,
//            appExecutors: AppExecutors
//        ): MealRepository =
//            instance ?: synchronized(this) {
//                instance ?: MealRepository(remoteData, localData, appExecutors)
//            }
//    }

    override fun getAllMeal(): LiveData<Resource<List<Meal>>> =
        object : NetworkBoundResource<List<Meal>, List<MealResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Meal>> {
                return Transformations.map(localDataSource.getAllMeal()){
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Meal>?): Boolean {
                return true
            }

            override fun createCall(): LiveData<ApiResponse<List<MealResponse>>> {
                return remoteDataSource.getAllMeal()
            }

            override fun saveCallResult(data: List<MealResponse>) {
                val mealList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMeal(mealList = mealList)
            }

        }.asLiveData()

    override fun getFavoriteMeal(): LiveData<List<Meal>> {
        return  Transformations.map(localDataSource.getFavoriteMeal()){
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMeal(meal: Meal, state: Boolean) {
        val mealEntity = DataMapper.mapDomainToEntity(meal)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMeal(mealEntity, state) }
    }
}