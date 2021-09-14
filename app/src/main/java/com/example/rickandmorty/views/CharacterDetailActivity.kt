package com.example.rickandmorty.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.rickandmortyapp.R
import com.bumptech.glide.Glide

import com.example.rickandmorty.models.RmCharacter
import com.example.rickandmorty.services.RickAndMortyServiceProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_detail)
        val provider = RickAndMortyServiceProvider()
        val  intent=intent
        val id= intent.getStringExtra("charId") ?: ""
        var imgavatarUrl: String?
        val name: TextView = findViewById(R.id.name_textView)
        val gender: TextView = findViewById(R.id.gender_textView)
        val species: TextView = findViewById(R.id.species_textView)
        val status: TextView = findViewById(R.id.status_textView)
        val avatar: ImageView = findViewById(R.id.avatar_imageViewinner)


        println("!!!!    $id")

        provider.rickAndMortyService.getCharacter(id).enqueue(object :
                Callback<RmCharacter> {
            override fun onResponse(
                    call: Call<RmCharacter>,
                    response: Response<RmCharacter>
            ) {
                if (response.body() != null) {
                    println("-------------------------ID**************")
                    if (id != null) {
                        println(response.body()!!.name)
                        println(response.body()!!.id)
                        name.text= response.body()!!.name
                        gender.text=response.body()!!.gender
                        species.text=response.body()!!.species
                        status.text=response.body()!!.status
                        imgavatarUrl= response.body()!!.image
                        Glide.with(this@CharacterDetailActivity).load(imgavatarUrl)
                                .into(avatar)
                    }


                }

            }


            override fun onFailure(call: Call<RmCharacter>, t: Throwable) {
                Log.d("FAIL:::", "failure")
            }
        })








    }
}
