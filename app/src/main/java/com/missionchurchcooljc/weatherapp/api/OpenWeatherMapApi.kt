package com.missionchurchcooljc.weatherapp.api

import com.missionchurchcooljc.weatherapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("weather/{q}/{units}/{appid}/contributors")
    suspend fun getWeatherCityName(
        @Query("q") cityName: String,
        @Query("units") units: String = "Imperial",
        @Query("appid") apiKey: String = BuildConfig.OPENWEATHER_API_KEY
    ): Response<CityNameWeather>
}