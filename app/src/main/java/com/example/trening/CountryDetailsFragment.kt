package com.example.trening

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_country_details.*
import kotlinx.coroutines.launch


class CountryDetailsFragment : Fragment(), AdapterListener {

    val args: CountryDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val country = args.country
        nameTextView.text = country.country
        detailCasesTextView.text = country.cases.toString()
        detailDeathsTextView.text = country.deaths.toString()
        detailRecoveredTextView.text = country.recovered.toString()

        val adapter = CountriesAdapter(emptyList(), this)

    }

    override fun onCountryItemClick(country: Country) {
        TODO("Not yet implemented")
    }
}