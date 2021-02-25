package com.missionchurchcooljc.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missionchurchcooljc.weatherapp.data.CityNameWeather
import com.missionchurchcooljc.weatherapp.api.WeatherRepository
import com.missionchurchcooljc.weatherapp.data.WeatherViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    var weatherMutableLiveData = MutableLiveData<CityNameWeather>()

    private val _viewState = MutableLiveData<WeatherViewState>()
    val viewState: LiveData<WeatherViewState>
        get() = _viewState


    fun fetchWeatherAsMemberVar(cityName: String) {
        coroutineScope.launch {
            weatherMutableLiveData = weatherRepository.fetchLatestWeatherAsLiveData(cityName)
        }
    }

    fun fetchWeather(cityName: String) {
        coroutineScope.launch {
            val cityNameWeather = weatherRepository.fetchLatestWeather(cityName)
            Timber.d(cityNameWeather.city)
            emit(cityNameWeather)
        }
    }

    private fun emit(data: CityNameWeather? = null) {
        val viewState = WeatherViewState(data)
        _viewState.value = viewState
    }

}