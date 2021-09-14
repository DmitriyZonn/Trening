package com.example.trening.view.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trening.R
import com.example.trening.model.Country
import com.example.trening.view.AdapterListener
import com.example.trening.view.CountriesAdapter
import kotlinx.android.synthetic.main.fragment_countries.*


class CountriesFragment : Fragment(), AdapterListener, CountriesView {

    val presenter: CountriesFragmentPresenter = CountriesFragmentPresenter(this)

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
            presenter.onStartButtonClick()
        }

    }

    override fun onCountryItemClick(country: Country){
        val action =
            com.example.trening.CountriesFragmentDirections.actionCountriesFragmentToCountryDetailsFragment(
                country
            )
        findNavController().navigate(action)
    }

    override fun showProgressBar(){
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar(){
        progressBar.visibility = View.INVISIBLE
    }

    override fun showCountries(countries: List<Country>){
        val adapter = CountriesAdapter(countries, this@CountriesFragment)
        recyclerView.adapter = adapter
        statusTextView.text = "Ок"
    }

    override fun showError(){
        statusTextView.text = "Ошибка"
    }
}

