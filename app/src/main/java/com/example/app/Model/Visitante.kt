package com.example.app.Model

import com.google.gson.annotations.SerializedName

data class Visitante(
    val id: Long? = null,

    @SerializedName("nombre")
    val nombre: String,

    @SerializedName("documento")
    val documento: String,

    @SerializedName("telefono")
    val telefono: String,

    @SerializedName("accesoRecurrente")
    val accesoRecurrente: Boolean
)