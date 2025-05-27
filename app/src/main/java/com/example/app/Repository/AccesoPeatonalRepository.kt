package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.AccesoPeatonal

class AccesoPeatonalRepository {

    suspend fun obtenerAccesosPeatonales(): List<AccesoPeatonal> {
        return RetrofitClient.accesoPeatonalApiService .obtenerAccesosPeatonales()
    }

    suspend fun obtenerAccesoPeatonal(id: Long): AccesoPeatonal {
        return RetrofitClient.accesoPeatonalApiService.obtenerAccesoPeatonal(id)
    }

    suspend fun guardarAccesoPeatonal(accesoPeatonal: AccesoPeatonal): AccesoPeatonal {
        return RetrofitClient.accesoPeatonalApiService.guardarAccesoPeatonal(accesoPeatonal)
    }

    suspend fun eliminarAccesoPeatonal(id: Long) {
        RetrofitClient.accesoPeatonalApiService.eliminarAccesoPeatonal(id)
    }
}
