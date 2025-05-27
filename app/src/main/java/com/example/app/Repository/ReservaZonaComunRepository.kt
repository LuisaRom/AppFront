package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.ReservaZonaComun

class ReservaZonaComunRepository {

    suspend fun obtenerTodos(): List<ReservaZonaComun> {
        return RetrofitClient.reservaZonaComunApiService.obtenerReservas()
    }

    suspend fun obtenerPorId(id: Long): ReservaZonaComun {
        return RetrofitClient.reservaZonaComunApiService.obtenerReserva(id)
    }

    suspend fun guardar(reserva: ReservaZonaComun): ReservaZonaComun {
        return RetrofitClient.reservaZonaComunApiService.guardarReserva(reserva)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.reservaZonaComunApiService.eliminarReserva(id)
    }
}
