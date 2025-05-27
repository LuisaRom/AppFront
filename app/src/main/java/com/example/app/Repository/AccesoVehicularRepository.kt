package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.AccesoVehicular

class AccesoVehicularRepository {

    suspend fun obtenerTodos(): List<AccesoVehicular> {
        return RetrofitClient.accesoVehicularApiService.obtenerAccesosVehiculares()
    }

    suspend fun obtenerPorId(id: Long): AccesoVehicular {
        return RetrofitClient.accesoVehicularApiService.obtenerAccesoVehicular(id)
    }

    suspend fun guardar(accesoVehicular: AccesoVehicular): AccesoVehicular {
        return RetrofitClient.accesoVehicularApiService.guardarAccesoVehicular(accesoVehicular)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.accesoVehicularApiService.eliminarAccesoVehicular(id)
    }
}
