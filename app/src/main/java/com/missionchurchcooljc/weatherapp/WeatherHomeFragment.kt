package com.missionchurchcooljc.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.missionchurchcooljc.weatherapp.databinding.FragmentWeatherHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherHomeFragment : Fragment() {
    private lateinit var binding: FragmentWeatherHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearchWeather.setOnClickListener {
            val cityName = binding.input.text.toString()
            val direction = WeatherHomeFragmentDirections
                .actionWeatherHomeFragmentToWeatherListFragment(cityName)
            findNavController()
                .navigate(direction)
        }
    }
}