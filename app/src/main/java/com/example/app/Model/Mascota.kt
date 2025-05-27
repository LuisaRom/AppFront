package com.example.app.Model

import com.google.gson.annotations.SerializedName

data class Mascota(
    val id: Long? = null,

    @SerializedName("nombre")
    val nombre: String,

    @SerializedName("tipo")
    val tipo: String,

    @SerializedName("raza")
    val raza: String,

    @SerializedName("usuario")
    val usuario: Usuario? = null
)