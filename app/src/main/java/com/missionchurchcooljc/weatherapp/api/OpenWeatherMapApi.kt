package com.missionchurchcooljc.weatherapp.api

import androidx.lifecycle.MutableLiveData
import com.missionchurchcooljc.weatherapp.BuildConfig
import com.missionchurchcooljc.weatherapp.data.CityNameWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("weather")
    suspend fun getWeatherCityNameAsLiveData(
        @Query("q") cityName: String,
        @Query("units") units: String = "Imperial",
        @Query("appid") apiKey: String = BuildConfig.OPENWEATHER_API_KEY
    ): MutableLiveData<CityNameWeather>

    @GET("weather")
    suspend fun getWeatherCityName(
        @Query("q") cityName: String,
        @Query("units") units: String = "Imperial",
        @Query("appid") apiKey: String = BuildConfig.OPENWEATHER_API_KEY
    ): CityNameWeather
}