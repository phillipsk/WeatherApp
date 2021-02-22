package com.missionchurchcooljc.weatherapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.missionchurchcooljc.weatherapp.api.CityNameWeather

import com.missionchurchcooljc.weatherapp.databinding.FragmentWeatherDetailBinding

class WeatherListAdapter
    : ListAdapter<CityNameWeather, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            FragmentWeatherDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as WeatherViewHolder).bind(item)
    }

    class WeatherViewHolder(
        private val binding: FragmentWeatherDetailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.weatherMainObj?.let { item ->
                    navigateToDetails(item, it)
                }
            }
        }

        private fun navigateToDetails(
            weather: CityNameWeather,
            view: View
        ) {
            val direction =
                WeatherListFragmentDirections.actionWeatherListFragmentToWeatherListDetailFragment(
                    weather.weatherSummary.first() as Int // TODO: implement Details screen
                )
            view.findNavController().navigate(direction)
        }

        fun bind(item: CityNameWeather) {
            binding.apply {
                weatherMainObj = item
                executePendingBindings()
            }
        }
    }


    class DiffCallback : DiffUtil.ItemCallback<CityNameWeather>() {
        override fun areItemsTheSame(
            oldItem: CityNameWeather,
            newItem: CityNameWeather
        ): Boolean {
            return oldItem.weatherSummary == newItem.weatherSummary
        }

        override fun areContentsTheSame(
            oldItem: CityNameWeather,
            newItem: CityNameWeather
        ): Boolean {
            return oldItem == newItem
        }
    }
}


