package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.Mascota


class MascotaRepository {

    suspend fun obtenerTodos(): List<Mascota> {
        return RetrofitClient.mascotaApiService.obtenerMascotas()
    }

    suspend fun obtenerPorId(id: Long): Mascota {
        return RetrofitClient.mascotaApiService.obtenerMascota(id)
    }

    suspend fun guardar(mascota: Mascota): Mascota {
        return RetrofitClient.mascotaApiService.guardarMascota(mascota)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.mascotaApiService.eliminarMascota(id)
    }
}