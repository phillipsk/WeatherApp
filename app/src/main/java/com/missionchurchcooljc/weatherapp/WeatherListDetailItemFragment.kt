package com.missionchurchcooljc.weatherapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class WeatherListDetailItemFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherListDetailItemFragment()
    }

    private lateinit var viewModel: WeatherListDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_list_detail_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}