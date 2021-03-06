package com.example.rickandmorty.services

import com.example.rickandmorty.models.CharacterResponse
import com.example.rickandmorty.models.RmCharacter
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("/api/character")
    fun getAllCharacters(): Call<CharacterResponse>

    @GET("/api/character/{id}")
    fun getCharacter(@Path ("id") id: String):Call<RmCharacter>


}