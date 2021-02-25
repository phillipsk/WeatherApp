package com.missionchurchcooljc.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.missionchurchcooljc.weatherapp.api.WeatherRepository
import com.missionchurchcooljc.weatherapp.databinding.FragmentWeatherListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeatherListFragment : Fragment() {

    private val args: WeatherListFragmentArgs by navArgs()
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var binding: FragmentWeatherListBinding

    @Inject
    lateinit var weatherRepository: WeatherRepository //    TODO: use constructor injection instead


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }

//        binding.setClickListener {  }
//            navigateToPlantListPage()
//        }

        binding.cardView.setOnClickListener {
            val direction = WeatherListFragmentDirections
                .actionWeatherListFragmentToWeatherListDetailFragment(args.cityName)
            findNavController()
                .navigate(direction)
        }
        binding.weatherMain.setOnClickListener {
            val direction = WeatherListFragmentDirections
                .actionWeatherListFragmentToWeatherListDetailFragment(args.cityName)
            findNavController()
                .navigate(direction)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, { item ->
            binding.weather = item
        })
    }

    override fun onStart() {
        super.onStart()
        //    TODO: handle failed network request (duplicated in weatherRepository
        viewModel.fetchWeather(args.cityName)
    }
}