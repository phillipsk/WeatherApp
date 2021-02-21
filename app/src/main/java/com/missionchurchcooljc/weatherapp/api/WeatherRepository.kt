package com.missionchurchcooljc.weatherapp.api

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val openWeatherMapApi: OpenWeatherMapApi){

    sealed class Result {
        data class Success(val weather: CityNameWeather) : Result()
        object Failure: Result()
    }

    suspend fun fetchLatestWeather(cityName: String): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = openWeatherMapApi.getWeatherCityName(cityName)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }
        }
    }

}