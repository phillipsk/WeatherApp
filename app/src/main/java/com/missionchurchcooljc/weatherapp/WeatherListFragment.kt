package com.missionchurchcooljc.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.missionchurchcooljc.weatherapp.api.CityNameWeather
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

    //TODO: this can be scoped in onCreateView
    private val adapter = WeatherListAdapter()

    private val args: WeatherListFragmentArgs by navArgs()
//    TODO Implement viewModel
//    private val viewModel: WeatherViewModel by viewModels()

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
            val result =
                weatherRepository.fetchLatestWeather(cityName)
            val tempList: MutableList<CityNameWeather> = mutableListOf()
            tempList.add(result) //TODO: fix this workaround
            adapter.submitList(tempList)
        }
    }

    //    TODO: handle failed network request (duplicated in weatherRepository
    private fun onFetchFailed() {
        Log.d("onFetchFailed", "{${this.javaClass.simpleName}} :: onFetchFailed")
    }
}