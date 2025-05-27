package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.Mascota
import com.example.app.Repository.MascotaRepository
import kotlinx.coroutines.launch

class MascotaViewModel : ViewModel() {
    private val repository = MascotaRepository()
    val mascotas = MutableLiveData<List<Mascota>>()

    fun obtenerTodos() = viewModelScope.launch {
        mascotas.postValue(repository.obtenerTodos())
    }

    fun guardar(mascota: Mascota) = viewModelScope.launch {
        repository.guardar(mascota)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}