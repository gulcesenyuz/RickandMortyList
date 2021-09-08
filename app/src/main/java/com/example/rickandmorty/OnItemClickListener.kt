package com.example.rickandmorty

interface OnItemClickListener {
    fun onItemClick(
        position: Int,
        gender: String?,
        species: String?,
        status: String?,
        image: String?,
        name: String?,
    )
}