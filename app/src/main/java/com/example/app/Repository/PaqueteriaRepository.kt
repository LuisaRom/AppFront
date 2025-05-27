package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.Paqueteria

class PaqueteriaRepository {

    suspend fun obtenerTodos(): List<Paqueteria> {
        return RetrofitClient.paqueteriaApiService.obtenerPaqueteria()
    }

    suspend fun obtenerPorId(id: Long): Paqueteria {
        return RetrofitClient.paqueteriaApiService.obtenerPaquete(id)
    }

    suspend fun guardar(paqueteria: Paqueteria): Paqueteria {
        return RetrofitClient.paqueteriaApiService.guardarPaquete(paqueteria)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.paqueteriaApiService.eliminarPaquete(id)
    }
}
