package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.ReservaZonaComun
import com.example.app.Repository.ReservaZonaComunRepository
import kotlinx.coroutines.launch

class ReservaZonaComunViewModel : ViewModel() {
    private val repository = ReservaZonaComunRepository()
    val reservas = MutableLiveData<List<ReservaZonaComun>>()

    fun obtenerTodos() = viewModelScope.launch {
        reservas.postValue(repository.obtenerTodos())
    }

    fun guardar(reserva: ReservaZonaComun) = viewModelScope.launch {
        repository.guardar(reserva)
        obtenerTodos()
    }

    fun eliminar(id: Long) = viewModelScope.launch {
        repository.eliminar(id)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}