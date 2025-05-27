package com.example.app.Model

import com.google.gson.annotations.SerializedName

data class VehiculoResidente(
    val id: Long? = null,

    @SerializedName("placa")
    val placa: String,

    @SerializedName("marca")
    val marca: String,

    @SerializedName("modelo")
    val modelo: String,

    @SerializedName("color")
    val color: String,

    @SerializedName("usuario")
    val usuario:Usuario
)