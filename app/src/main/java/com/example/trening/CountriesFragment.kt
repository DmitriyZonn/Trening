package com.example.trening

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_countries.*
import kotlinx.coroutines.launch


class CountriesFragment : Fragment(), AdapterListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start.setOnClickListener {
            lifecycleScope.launch {
                val countriesList = covidStatService.getAllCountriesStat()
                val adapter = CountriesAdapter(countriesList, this@CountriesFragment)
                recyclerView.adapter = adapter
            }
        }

    }


    override fun onCountryItemClick(country: Country){
        val action = CountriesFragmentDirections.actionCountriesFragmentToCountryDetailsFragment(country)
        findNavController().navigate(action)
    }


}