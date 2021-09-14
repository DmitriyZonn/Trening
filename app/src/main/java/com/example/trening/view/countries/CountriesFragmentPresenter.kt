package com.example.trening.view.countries

import com.example.trening.model.Country
import com.example.trening.model.covidStatService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface CountriesView{
    fun showProgressBar()
    fun hideProgressBar()
    fun showCountries(countries: List<Country>)
    fun showError()
}

class CountriesFragmentPresenter (val view: CountriesView){
    fun onStartButtonClick(){
        view.showProgressBar()
        try {
            GlobalScope.launch {
                val countriesList = covidStatService.getAllCountriesStat()
                view.showCountries(countriesList)
            }
        }catch (e: Exception){
            view.showError()
        }
        view.hideProgressBar()
    }
}