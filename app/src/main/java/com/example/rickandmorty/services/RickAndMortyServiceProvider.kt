package com.example.rickandmorty.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyServiceProvider {

    val baseUrl = "https://rickandmortyapi.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    val rickAndMortyService: RickAndMortyService = retrofit.create<RickAndMortyService>(
        RickAndMortyService::class.java
    )

}