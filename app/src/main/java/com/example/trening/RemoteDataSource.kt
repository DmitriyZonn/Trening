package com.example.trening

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface CovidStatService {
    @GET("/v3/covid-19/countries/{country}")
    suspend fun getStat(@Path("country") countryName: String): Country

    @GET("/v3/covid-19/countries")
    suspend fun getAllCountriesStat(): List<Country>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://disease.sh")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var covidStatService: CovidStatService = retrofit.create(CovidStatService::class.java)

