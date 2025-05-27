package com.example.app.Interfaces

import com.example.app.Model.VehiculoResidente
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VehiculoResidenteApiService {

    @GET("/api/vehiculos-residentes")
    suspend fun obtenerVehiculos(): List<VehiculoResidente>

    @GET("/api/vehiculos-residentes/{id}")
    suspend fun obtenerVehiculo(@Path("id") id: Long): VehiculoResidente

    @POST("/api/vehiculos-residentes")
    suspend fun guardarVehiculo(@Body vehiculo: VehiculoResidente): VehiculoResidente

    @DELETE("/api/vehiculos-residentes/{id}")
    suspend fun eliminarVehiculo(@Path("id") id: Long)
}