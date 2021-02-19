package com.missionchurchcooljc.weatherapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class WeatherHomeFragment : Fragment() {

    //    TODO:
//          dagger, databinding, coroutine, Room
    companion object {
        fun newInstance() = WeatherHomeFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_weather_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

//        findNavController().addOnDestinationChangedListener { _, _, _ ->
//            toolbar.title = ""
//        }

        view.findViewById<Button>(R.id.btnSearch_weather).setOnClickListener {
            findNavController().navigate(R.id.action_weatherHomeFragment_to_weatherListFragment)
        }

//        val btnSearch = view.findViewById<Button>(R.id.btnSearch_weather)
//        btnSearch?.setOnClickListener {
//            Navigation.findNavController(view)
//                .navigate(R.id.action_weatherHomeFragment_to_weatherListFragment)
//        }
    }

}