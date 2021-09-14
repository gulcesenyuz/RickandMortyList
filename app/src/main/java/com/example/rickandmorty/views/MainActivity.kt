package com.example.rickandmorty.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.android.rickandmortyapp.R
import com.example.rickandmorty.services.RmCharacterAdapter
import com.example.rickandmorty.constants.OnItemClickListener
import com.example.rickandmorty.models.CharacterResponse
import com.example.rickandmorty.services.RickAndMortyServiceProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun onItemClick(
            id: String,

            ) {

        val intent = Intent(applicationContext, CharacterDetailActivity::class.java)
        intent.putExtra("charId", id)
        startActivity(intent)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = RickAndMortyServiceProvider()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        provider.rickAndMortyService.getAllCharacters().enqueue(object :
                Callback<CharacterResponse> {
            override fun onResponse(
                    call: Call<CharacterResponse>,
                    response: Response<CharacterResponse>
            ) {
                if (response.body() != null) {
                    println("**********ID**************")
                    println(response.body()!!.results[2].gender)
                    println(response.body()!!.results[2].id)
                    val adapter = RmCharacterAdapter(
                            response.body()!!.results, this@MainActivity
                    )
                    recyclerView.adapter = adapter
                }

            }


            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.d("FAIL:::", "failure")
            }
        })



    }

}