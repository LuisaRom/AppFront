package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.Visitante
import com.example.app.Repository.VisitanteRepository
import kotlinx.coroutines.launch

class VisitanteViewModel : ViewModel() {
    private val repository = VisitanteRepository()
    val visitantes = MutableLiveData<List<Visitante>>()

    fun obtenerTodos() = viewModelScope.launch {
        visitantes.postValue(repository.obtenerTodos())
    }

    fun guardar(visitante: Visitante) = viewModelScope.launch {
        repository.guardar(visitante)
        obtenerTodos()
    }

    fun eliminar(id: Long) = viewModelScope.launch {
        repository.eliminar(id)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}