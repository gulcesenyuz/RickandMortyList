package com.example.rickandmorty.views

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.android.rickandmortyapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


class CharacterDetail : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_detail)

        var statustext: TextView = findViewById(R.id.status_textView)
        var nametext:TextView = findViewById(R.id.name_textView)
        var speciestext:TextView = findViewById(R.id.species_textView)
        var gendertext:TextView = findViewById(R.id.gender_textView)

        var avatar: ImageView = findViewById(R.id.avatar_imageViewinner)

        val  intent=intent
        val gender= intent.getStringExtra("gender")
        val species= intent.getStringExtra("species")
        val status= intent.getStringExtra("status")
        val imgavatarUrl=intent.getStringExtra("avatar")
        val name = intent.getStringExtra("name")

        Glide.with(this).load(imgavatarUrl)
            .into(avatar)

        statustext.text= status
        nametext.text= name
        speciestext.text= species
        gendertext.text= gender



    }
}
