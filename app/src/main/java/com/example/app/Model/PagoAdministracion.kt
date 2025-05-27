package com.example.app.Model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class PagoAdministracion(
    val id: Long? = null,

    @SerializedName("monto")
    val monto: BigDecimal,

    @SerializedName("fechaPago")
    val fechaPago: String?,  // Formato ISO 8601

    @SerializedName("metodoPago")
    val metodoPago: String,

    @SerializedName("usuario")
    val usuario: Usuario? = null
)

//Preguntar al profe porque no deja poner enumclass y si es mejor dejarlo y agregar un nuevo archivo o asi como esta