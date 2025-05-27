package com.example.app.ViewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.AccesoVehicular
import com.example.app.Repository.AccesoVehicularRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AccesoVehicularViewModel : ViewModel() {

    private val repository = AccesoVehicularRepository()

    private val _accesosVehiculares = MutableLiveData<List<AccesoVehicular>?>(emptyList())
    val accesosVehiculares: MutableLiveData<List<AccesoVehicular>?> = _accesosVehiculares

    fun obtenerAccesosVehiculares() {
        viewModelScope.launch {
            val lista = withContext(Dispatchers.IO) {
                repository.obtenerTodos()
            }
            _accesosVehiculares.postValue(lista)
        }
    }

    fun obtenerAccesoVehicular(id: Long) {
        viewModelScope.launch {
            val acceso = withContext(Dispatchers.IO) {
                repository.obtenerPorId(id)
            }
            // Aquí puedes usar otro LiveData para exponer ese acceso si lo necesitas.
        }
    }

    fun guardarAccesoVehicular(accesoVehicular: AccesoVehicular) {
        viewModelScope.launch {
            repository.guardar(accesoVehicular)
            obtenerAccesosVehiculares()
        }
    }

    fun eliminarAccesoVehicular(id: Long) {
        viewModelScope.launch {
            repository.eliminar(id)
            obtenerAccesosVehiculares()
        }
    }
}