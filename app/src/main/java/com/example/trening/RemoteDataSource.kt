package com.example.trening

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object RemoteDataSource {
    private interface CovidStatService {
        @GET("/v3/covid-19/countries/{country}")
        suspend fun getStat(@Path("country") countryName: String): Country

        @GET("/v3/covid-19/countries")
        suspend fun getAllCountriesStat(): List<Country>
    }

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://disease.sh")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var covidStatService: CovidStatService = retrofit.create(CovidStatService::class.java)


    suspend fun getAllCountriesStat(): List<Country>{
        return covidStatService.getAllCountriesStat()
    }

    suspend fun getStat(@Path("country") countryName: String): Country{
        return covidStatService.getStat(countryName)
    }
}