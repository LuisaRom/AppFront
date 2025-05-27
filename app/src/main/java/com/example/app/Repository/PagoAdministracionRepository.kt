package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.PagoAdministracion

class PagoAdministracionRepository {

    suspend fun obtenerTodos(): List<PagoAdministracion> {
        return RetrofitClient.pagoAdministracionApiService.obtenerPagos()
    }

    suspend fun obtenerPorId(id: Long): PagoAdministracion {
        return RetrofitClient.pagoAdministracionApiService.obtenerPago(id)
    }

    suspend fun guardar(pagoAdministracion: PagoAdministracion): PagoAdministracion {
        return RetrofitClient.pagoAdministracionApiService.guardarPago(pagoAdministracion)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.pagoAdministracionApiService.eliminarPago(id)
    }
}
