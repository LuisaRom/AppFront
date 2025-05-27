package com.example.app.Repository

import com.example.app.Interfaces.RetrofitClient.RetrofitClient
import com.example.app.Model.Notificacion

class NotificacionRepository {

    suspend fun obtenerTodos(): List<Notificacion> {
        return RetrofitClient.notificacionApiService.obtenerNotificaciones()
    }

    suspend fun obtenerPorId(id: Long): Notificacion {
        return RetrofitClient.notificacionApiService.obtenerNotificacion(id)
    }

    suspend fun guardar(notificacion: Notificacion): Notificacion {
        return RetrofitClient.notificacionApiService.guardarNotificacion(notificacion)
    }

    suspend fun eliminar(id: Long) {
        RetrofitClient.notificacionApiService.eliminarNotificacion(id)
    }
}