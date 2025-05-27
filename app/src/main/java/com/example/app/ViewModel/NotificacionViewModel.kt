package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.Notificacion
import com.example.app.Repository.NotificacionRepository
import kotlinx.coroutines.launch

class NotificacionViewModel : ViewModel() {
    private val repository = NotificacionRepository()
    val notificaciones = MutableLiveData<List<Notificacion>>()

    fun obtenerTodos() = viewModelScope.launch {
        notificaciones.postValue(repository.obtenerTodos())
    }

    fun guardar(notificacion: Notificacion) = viewModelScope.launch {
        repository.guardar(notificacion)
        obtenerTodos()
    }

    fun eliminar(id: Long) = viewModelScope.launch {
        repository.eliminar(id)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}