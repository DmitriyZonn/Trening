package com.example.trening.view.countries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trening.Country
import com.example.trening.covidStatService
import kotlinx.coroutines.launch

class CountriesFragmentViewModel : ViewModel() {
    var countries: MutableLiveData<List<Country>> = MutableLiveData()
    var status: MutableLiveData<String> = MutableLiveData("")
    var isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun onStartButtonClick() {
        isLoading.value = true
        try {
            viewModelScope.launch {
                val countriesList = covidStatService.getAllCountriesStat()
                countries.value = countriesList
                status.value = "Ok"
            }
        } catch (e: Exception) {
            status.value = "Ошибка"
        }
        isLoading.value = false
    }
}