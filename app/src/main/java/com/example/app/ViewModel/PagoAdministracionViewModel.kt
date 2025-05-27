package com.example.app.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.PagoAdministracion
import com.example.app.Repository.PagoAdministracionRepository
import kotlinx.coroutines.launch

class PagoAdministracionViewModel : ViewModel() {

    private val repository = PagoAdministracionRepository()

    val pagos = MutableLiveData<List<PagoAdministracion>>()

    fun obtenerTodos() = viewModelScope.launch {
        pagos.postValue(repository.obtenerTodos())
    }

    fun guardar(pago: PagoAdministracion) = viewModelScope.launch {
        repository.guardar(pago)
        obtenerTodos()
    }

    fun eliminar(id: Long) = viewModelScope.launch {
        repository.eliminar(id)
        obtenerTodos()
    }

    suspend fun obtenerPorId(id: Long) = repository.obtenerPorId(id)
}