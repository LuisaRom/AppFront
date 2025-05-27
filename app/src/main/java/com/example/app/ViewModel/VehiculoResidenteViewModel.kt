package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.VehiculoResidente
import com.example.app.Repository.VehiculoResidenteRepository
import kotlinx.coroutines.launch

class VehiculoResidenteViewModel : ViewModel() {
    private val repository = VehiculoResidenteRepository()
    val vehiculos = MutableLiveData<List<VehiculoResidente>>()

    fun obtenerTodos() = viewModelScope.launch {
        vehiculos.postValue(repository.obtenerTodos())
    }

    fun guardar(vehiculo: VehiculoResidente) = viewModelScope.launch {
        repository.guardar(vehiculo)
        obtenerTodos()
    }

    fun eliminar(id: Long) = viewModelScope.launch {
        repository.eliminar(id)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}