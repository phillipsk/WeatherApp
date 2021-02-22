package com.missionchurchcooljc.weatherapp.api

import com.google.gson.annotations.SerializedName

data class CityNameWeather(
    @field:SerializedName("weather") val weatherSummary: List<WeatherSummary>,
    @field:SerializedName("main") val weatherDetails: WeatherDetails,
    @field:SerializedName("name") val city: String

) {
    data class WeatherSummary(
        @field:SerializedName("id") val id: Int,
        @field:SerializedName("main") val main: String,
        @field:SerializedName("description") val description: String,
        @field:SerializedName("icon") val icon: String
    )

    class WeatherDetails(
        @field:SerializedName("temp") val temp: String,
        @field:SerializedName("feels_like") val feelsLike: Double,
        @field:SerializedName("temp_min") val tempMin: Double,
        @field:SerializedName("temp_max") val tempMax: Double,
        @field:SerializedName("pressure") val pressure: Int,
        @field:SerializedName("humidity") val humidity: Int,
    )
}