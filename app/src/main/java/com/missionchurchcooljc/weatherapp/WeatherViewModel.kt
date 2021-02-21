package com.missionchurchcooljc.weatherapp

import androidx.lifecycle.ViewModel
import com.missionchurchcooljc.weatherapp.api.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val coroutineScope = CoroutineScope(
        SupervisorJob() +
                Dispatchers.Main.immediate
    )

//    fun fetchWeather(cityName: String) {
//        coroutineScope.launch {
////            viewMvc.showProgressIndication()
//            try {
//                val result = weatherRepository.fetchLatestWeather(cityName)
//                when (result) {
//                    is WeatherRepository.Result.Success -> {
//                        adapter.submitList(result.weather.weatherSummary)
////                        isDataLoaded = true
//                    }
//                    is WeatherRepository.Result.Failure -> onFetchFailed()
//                }
//            } finally {
////                viewMvc.hideProgressIndication()
//            }
//
//        }
//    }
}