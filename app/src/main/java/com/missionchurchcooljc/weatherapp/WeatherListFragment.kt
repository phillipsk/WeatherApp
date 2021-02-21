package com.missionchurchcooljc.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.missionchurchcooljc.weatherapp.api.WeatherRepository
import com.missionchurchcooljc.weatherapp.databinding.FragmentWeatherListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class WeatherListFragment : Fragment() {

    //TODO: this should be scoped in onCreateView, see Church App
    private val adapter = WeatherListAdapter()

    private val args: WeatherListFragmentArgs by navArgs()
    private var searchJob: Job? = null
//    private val viewModel: WeatherViewModel by viewModels()

    private var columnCount = 1

    //    TODO: use constructor injection instead
    @Inject
    lateinit var weatherRepository: WeatherRepository


    private val coroutineScope = CoroutineScope(
        SupervisorJob() +
                Dispatchers.Main.immediate
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.list.adapter = adapter
        fetchWeather(args.cityName)

        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        return binding.root
    }


    fun fetchWeather(cityName: String) {
        coroutineScope.launch {
            try {
                val result = weatherRepository.fetchLatestWeather(cityName)
                when (result) {
                    is WeatherRepository.Result.Success -> {
                        adapter.submitList(result.weather.weatherSummary)
                    }
                    is WeatherRepository.Result.Failure -> onFetchFailed()
                }
            } finally {
            }

        }
    }

    private fun onFetchFailed() {
        TODO("Not yet implemented")
    }
}