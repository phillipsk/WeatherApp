//package com.missionchurchcooljc.weatherapp
//
//import com.missionchurchcooljc.weatherapp.api.CityNameWeather
//import com.missionchurchcooljc.weatherapp.api.OpenWeatherMapApi
//import com.missionchurchcooljc.weatherapp.api.WeatherRepository
//import dagger.hilt.android.testing.HiltAndroidRule
//import dagger.hilt.android.testing.HiltAndroidTest
//import kotlinx.coroutines.runBlocking
//import org.hamcrest.CoreMatchers.instanceOf
//import org.junit.Assert.assertEquals
//import org.junit.Assert.assertThat
//import org.junit.Rule
//import org.junit.Test
//import javax.inject.Inject
//
//@HiltAndroidTest
//class WeatherApiTest {
//
//    @get:Rule
//    var hiltRule = HiltAndroidRule(this)
//
//    @Inject
//    lateinit var weatherRepository: WeatherRepository
//
//
//    @Test
//    fun testWeatherAPI() {
//        runBlocking {
//            val result = weatherRepository.fetchLatestWeather("Boston")
//
////            assertEquals(CityNameWeather.WeatherSummary, result.weatherSummary)
////            assertEquals(CityNameWeather.WeatherDetails, result.weatherSummary)
//
//            assertThat(result, instanceOf(CityNameWeather::class.java))
//        }
//    }
//
//}