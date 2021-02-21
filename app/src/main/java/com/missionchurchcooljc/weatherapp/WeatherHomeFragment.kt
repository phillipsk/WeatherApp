package com.missionchurchcooljc.weatherapp

import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.missionchurchcooljc.weatherapp.databinding.FragmentWeatherHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherHomeFragment : Fragment() {

    //    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//    val weatherViewModel: WeatherViewModel by viewModels {
//        viewModelFactory
//    }
    private lateinit var binding: FragmentWeatherHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherHomeBinding.inflate(inflater, container, false)
//        context ?: return binding.root
//  fetch weather

        return binding.root
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

//        findNavController().addOnDestinationChangedListener { _, _, _ ->
//            toolbar.title = ""
//        }
        binding.btnSearchWeather.setOnClickListener {
            val cityName = binding.input.text.toString()
            val direction = WeatherHomeFragmentDirections
                .actionWeatherHomeFragmentToWeatherListFragment(cityName)
            findNavController()
                .navigate(direction)
        }

//        initSearchInputListener()

    }

    private fun initSearchInputListener() {

        binding.input.setOnEditorActionListener { view: View, actionId: Int, _: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                search(view)
//                fetchWeather(binding.input.text.toString())
                true
            } else {
                false
            }
        }
        binding.input.setOnKeyListener { view: View, keyCode: Int, event: KeyEvent ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
//                search(view)
//                fetchWeather(binding.input.text.toString())
                true
            } else {
                false
            }
        }
    }

    private fun search(v: View) {
        val input = view?.findViewById<EditText>(R.id.input)

        val query = input?.text.toString()
        // Dismiss keyboard
        dismissKeyboard(v.windowToken)
//        weatherViewModel.setQuery(query)
    }

    private fun dismissKeyboard(windowToken: IBinder) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    }


}