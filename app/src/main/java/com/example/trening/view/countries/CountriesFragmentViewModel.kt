package com.example.trening.view.countries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trening.Country
import com.example.trening.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesFragmentViewModel : ViewModel() {
    var countries: MutableLiveData<List<Country>> = MutableLiveData()
    var status: MutableLiveData<String> = MutableLiveData("")
    var isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun onStartButtonClick() {
        isLoading.value = true
        try {
            viewModelScope.launch {
                val countriesList: List<Country> = RemoteDataSource.getAllCountriesStat()
                val filteredList = countriesList.filter { it.cases>1000 }
                countries.value = countriesList
                status.value = "Ok"
            }
        } catch (e: Exception) {
            status.value = "Ошибка"
        }
        isLoading.value = false
    }

    fun some(){
        val countriesValues = countries.value
        if(countriesValues != null){
            val result = countriesValues.map{

            }
        }

        countries.value?.let{
            val result = it.map{

            }
        }

    }
}