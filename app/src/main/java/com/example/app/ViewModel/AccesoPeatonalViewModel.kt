package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.AccesoPeatonal
import com.example.app.Repository.AccesoPeatonalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AccesoPeatonalViewModel : ViewModel() {

    private val repository = AccesoPeatonalRepository()

    private val _accesosPeatonales = MutableLiveData<List<AccesoPeatonal>?>(emptyList())
    val accesosPeatonales: MutableLiveData<List<AccesoPeatonal>?> = _accesosPeatonales

    fun obtenerAccesosPeatonales() {
        viewModelScope.launch {
            val lista = withContext(Dispatchers.IO) {
                repository.obtenerAccesosPeatonales()
            }
            _accesosPeatonales.postValue(lista)
        }
    }

    fun obtenerAccesoPeatonal(id: Long) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.obtenerAccesoPeatonal(id)
            }
        }
    }

    fun guardarAccesoPeatonal(accesoPeatonal: AccesoPeatonal) {
        viewModelScope.launch {
            repository.guardarAccesoPeatonal(accesoPeatonal)
            obtenerAccesosPeatonales()
        }
    }

    fun eliminarAccesoPeatonal(id: Long) {
        viewModelScope.launch {
            repository.eliminarAccesoPeatonal(id)
            obtenerAccesosPeatonales()
        }
    }
}