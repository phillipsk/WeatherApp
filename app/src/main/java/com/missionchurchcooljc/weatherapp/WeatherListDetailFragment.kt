package com.missionchurchcooljc.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.missionchurchcooljc.weatherapp.databinding.FragmentWeatherListDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListDetailFragment : Fragment() {

    private val args: WeatherListDetailFragmentArgs by navArgs()
    private val viewModel: WeatherViewModel by viewModels()

    private lateinit var binding: FragmentWeatherListDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWeatherListDetailBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.toolbarDetail.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, { item ->
            binding.weather = item })
    }

    override fun onStart() {
        super.onStart()
        //    TODO: handle failed network request (duplicated in weatherRepository)
        viewModel.fetchWeather(args.cityName)
    }

}