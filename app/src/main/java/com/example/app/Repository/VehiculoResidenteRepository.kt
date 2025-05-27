package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.VehiculoResidente


class VehiculoResidenteRepository {

    suspend fun obtenerTodos(): List<VehiculoResidente> {
        return RetrofitClient.vehiculoResidenteApiService.obtenerVehiculos()
    }

    suspend fun obtenerPorId(id: Long): VehiculoResidente {
        return RetrofitClient.vehiculoResidenteApiService.obtenerVehiculo(id)
    }

    suspend fun guardar(vehiculoResidente: VehiculoResidente): VehiculoResidente {
        return RetrofitClient.vehiculoResidenteApiService.guardarVehiculo(vehiculoResidente)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.vehiculoResidenteApiService.eliminarVehiculo(id)
    }
}
