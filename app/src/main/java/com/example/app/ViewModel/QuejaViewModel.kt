package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.Queja
import com.example.app.Repository.QuejaRepository
import kotlinx.coroutines.launch

class QuejaViewModel : ViewModel() {
    private val repository = QuejaRepository()
    val quejas = MutableLiveData<List<Queja>>()

    fun obtenerTodos() = viewModelScope.launch {
        quejas.postValue(repository.obtenerTodos())
    }

    fun guardar(queja: Queja) = viewModelScope.launch {
        repository.guardar(queja)
        obtenerTodos()
    }

    fun eliminar(id: Long) = viewModelScope.launch {
        repository.eliminar(id)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}