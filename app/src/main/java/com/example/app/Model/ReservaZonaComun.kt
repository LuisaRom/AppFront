package com.example.app.Model

import com.google.gson.annotations.SerializedName

data class ReservaZonaComun(
    val id: Long? = null,

    @SerializedName("zonaComun")
    val zonaComun: String,

    @SerializedName("fechaReserva")
    val fechaReserva: String,  // Formato ISO "yyyy-MM-dd"

    @SerializedName("horaInicio")
    val horaInicio: String,    // Formato "HH:mm"

    @SerializedName("horaFin")
    val horaFin: String,       // Formato "HH:mm"

    @SerializedName("usuario")
    val usuario: Usuario?=null
)