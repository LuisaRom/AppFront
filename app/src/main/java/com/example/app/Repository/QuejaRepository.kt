package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.Queja

class QuejaRepository {

    suspend fun obtenerTodos(): List<Queja> {
        return RetrofitClient.quejaApiService.obtenerQuejas()
    }

    suspend fun obtenerPorId(id: Long): Queja {
        return RetrofitClient.quejaApiService.obtenerQueja(id)
    }

    suspend fun guardar(queja: Queja): Queja {
        return RetrofitClient.quejaApiService.guardarQueja(queja)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.quejaApiService.eliminarQueja(id)
    }
}