package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.Paqueteria
import com.example.app.Repository.PaqueteriaRepository
import kotlinx.coroutines.launch

class PaqueteriaViewModel : ViewModel() {
    private val repository = PaqueteriaRepository()
    val paquetes = MutableLiveData<List<Paqueteria>>()

    fun obtenerTodos() = viewModelScope.launch {
        paquetes.postValue(repository.obtenerTodos())
    }

    fun guardar(paqueteria: Paqueteria) = viewModelScope.launch {
        repository.guardar(paqueteria)
        obtenerTodos()
    }

    fun eliminar(id: Long) = viewModelScope.launch {
        repository.eliminar(id)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}