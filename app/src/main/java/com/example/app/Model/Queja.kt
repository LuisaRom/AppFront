package com.example.app.Model

import com.google.gson.annotations.SerializedName

data class Queja(
    val id: Long? = null,

    @SerializedName("descripcion")
    val descripcion: String,

    @SerializedName("fechaCreacion")
    val fechaCreacion: String?, // Formato ISO 8601

    @SerializedName("estado")
    val estado: String,

    @SerializedName("usuario")
    val usuario: Usuario? = null
)

//Preguntar al profe porque no deja poner enumclass y si es mejor dejarlo y agregar un nuevo archivo o asi como esta