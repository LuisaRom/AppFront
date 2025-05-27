package com.example.app.Model

import com.google.gson.annotations.SerializedName

data class Paqueteria(
    val id: Long? = null,

    @SerializedName("transportadora")
    val transportadora: String,

    @SerializedName("fechaRecepcion")
    val fechaRecepcion: String?,  // formato ISO 8601

    @SerializedName("estado")
    val estado: String,

    @SerializedName("usuario")
    val usuario: Usuario? = null
)
//Preguntar al profe porque no deja poner enumclass y si es mejor dejarlo y agregar un nuevo archivo o asi como esta


