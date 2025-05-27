package com.example.app.Interfaces

import com.example.app.Model.Visitante
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VisitanteApiService {
    @GET("/api/visitantes")
    suspend fun obtenerVisitantes(): List<Visitante>

    @GET("/api/visitantes/{id}")
    suspend fun obtenerVisitante(@Path("id") id: Long): Visitante

    @POST("/api/visitantes")
    suspend fun guardarVisitante(@Body visitante: Visitante): Visitante

    @DELETE("/api/visitantes/{id}")
    suspend fun eliminarVisitante(@Path("id") id: Long)
}
