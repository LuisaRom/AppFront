package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.Visitante

class VisitanteRepository {

    suspend fun obtenerTodos(): List<Visitante> {
        return RetrofitClient.visitanteApiService.obtenerVisitantes()
    }

    suspend fun obtenerPorId(id: Long): Visitante {
        return RetrofitClient.visitanteApiService.obtenerVisitante(id)
    }

    suspend fun guardar(visitante: Visitante): Visitante {
        return RetrofitClient.visitanteApiService.guardarVisitante(visitante)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.visitanteApiService.eliminarVisitante(id)
    }
}