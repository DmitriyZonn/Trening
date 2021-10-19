package com.example.trening.view.countries

import androidx.lifecycle.*
import com.example.trening.Country
import com.example.trening.RemoteDataSource
import kotlinx.coroutines.launch

class CountriesFragmentViewModel : ViewModel() {
    private var countriesLiveData: MutableLiveData<List<Country>> = MutableLiveData()
    private val filterTextLiveData: MutableLiveData<String> = MutableLiveData("")
    //private val sortTypeLiveData: MutableLiveData<Boolean> = MutableLiveData(true)
    val filteredCountriesLiveData = MediatorLiveData<List<Country>>().apply {
        addSource(countriesLiveData) { countries ->
            value = filterAndSortCountries()
        }
        addSource(filterTextLiveData) {
            value = filterAndSortCountries()
        }
        /*addSource(sortTypeLiveData) {
            value = filterAndSortCountries()
        }*/
    }

/*    val countriesCountLiveData = filteredCountriesLiveData.map { filteredCountries ->
        filteredCountries.size
    }*/

    private fun filterAndSortCountries(): List<Country> {
        val countries = countriesLiveData.value ?: emptyList()
        val filterText = filterTextLiveData.value ?: ""
        val filteredCountries = countries.filter { it.name.contains(filterText) }
        /*val sortTypeIsByName = sortTypeLiveData.value ?: true
        val sortedCountries = if (sortTypeIsByName)
            filteredCountries.sortedBy { it.name }
        else
            filteredCountries.sortedBy { it.cases }*/
        return filteredCountries
    }

    var statusLiveData: MutableLiveData<String> = MutableLiveData("")
    var isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)

    fun onStartButtonClick() {
        isLoadingLiveData.value = true
        try {
            viewModelScope.launch {
                val countriesList: List<Country> = RemoteDataSource.getAllCountriesStat()
                countriesLiveData.value = countriesList
                statusLiveData.value = "Ok"
            }
        } catch (e: Exception) {
            statusLiveData.value = "Ошибка"
        }
        isLoadingLiveData.value = false
    }

    fun onFilterTextChange(filterText: String) {
        filterTextLiveData.value = filterText
    }

/*    fun onSortTypeChange(value: Boolean) {
        sortTypeLiveData.value = value
    }*/
}