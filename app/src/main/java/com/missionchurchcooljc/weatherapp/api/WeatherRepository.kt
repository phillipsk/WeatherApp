package com.missionchurchcooljc.weatherapp.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val openWeatherMapApi: OpenWeatherMapApi) {


    suspend fun fetchLatestWeather(cityName: String): CityNameWeather {
        return withContext(Dispatchers.IO) {
            val response = openWeatherMapApi.getWeatherCityName(cityName)
            Timber.d(response.toString())
            return@withContext response

            //TODO: handle failed response

        }
    }

}