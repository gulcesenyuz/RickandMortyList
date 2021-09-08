package com.android.rickandmortyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.CharacterDetail
import com.example.rickandmorty.OnItemClickListener
import com.example.rickandmorty.models.CharacterResponse
import com.example.rickandmorty.services.RickAndMortyServiceProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class MainActivity : AppCompatActivity(),OnItemClickListener {

     override fun onItemClick(
         position: Int,
         gender: String?,
         species: String?,
         status: String?,
         image: String?,
         name: String?,
     ) {

         val intent = Intent(applicationContext, CharacterDetail::class.java)
        intent.putExtra("charId", position.toString() )
         intent.putExtra("gender", gender )
         intent.putExtra("species", species )
         intent.putExtra("status", status )
         intent.putExtra("avatar", image)
         intent.putExtra("name", name)



         println("gender   $gender")
         println("species   $species")
         println("status   $status")
         println("image   $image")
         println("position  $position")


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