package com.example.trening.view.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.trening.R
import com.example.trening.Country
import com.example.trening.databinding.FragmentCountriesBinding
import com.example.trening.view.AdapterListener
import com.example.trening.view.CountriesAdapter
import kotlinx.android.synthetic.main.fragment_countries.*


class CountriesFragment : Fragment(), AdapterListener {

//    val viewModel: CountriesFragmentViewModel = CountriesFragmentViewModel()
    val viewModel: CountriesFragmentViewModel by viewModels()
    lateinit var binding: FragmentCountriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCountriesBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        viewModel.countries.observe(viewLifecycleOwner) {
            showCountries(it)
        }
    }

    override fun onCountryItemClick(country: Country){
        val action =  CountriesFragmentDirections.actionCountriesFragmentToCountryDetailsFragment(
                country
            )
        findNavController().navigate(action)
    }


    fun showCountries(countries: List<Country>){
        val adapter = CountriesAdapter(countries, this@CountriesFragment)
        binding.recyclerView.adapter = adapter
    }
}

