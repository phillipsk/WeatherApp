package com.missionchurchcooljc.weatherapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.missionchurchcooljc.weatherapp.api.CityNameWeather

import com.missionchurchcooljc.weatherapp.placeholder.PlaceholderContent.PlaceholderItem
import com.missionchurchcooljc.weatherapp.databinding.FragmentWeatherDetailBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class WeatherListAdapter()
    : ListAdapter<CityNameWeather.WeatherSummary, WeatherListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    return ViewHolder(FragmentWeatherDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.idView.text = item.main
        holder.contentView.text = item.description
    }


    inner class ViewHolder(binding: FragmentWeatherDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CityNameWeather>() {
        override fun areItemsTheSame(oldItem: CityNameWeather, newItem: CityNameWeather): Boolean {
            return oldItem.weatherSummary == newItem.weatherSummary
        }

        override fun areContentsTheSame(oldItem: CityNameWeather, newItem: CityNameWeather): Boolean {
            return oldItem == newItem
        }
    }

}