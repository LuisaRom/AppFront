package com.example.app.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.Usuario
import com.example.app.Repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class UsuarioViewModel @Inject constructor(
    private val repository: UsuarioRepository
) : ViewModel() {

    private val _usuarios = MutableStateFlow<List<Usuario>>(emptyList())
    val usuarios: StateFlow<List<Usuario>> = _usuarios.asStateFlow()

    private val _usuarioActual = MutableStateFlow<Usuario?>(null)
    val usuarioActual: StateFlow<Usuario?> = _usuarioActual.asStateFlow()

    internal val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _rolSeleccionado = MutableStateFlow<String?>(null)
    val rolSeleccionado: StateFlow<String?> = _rolSeleccionado.asStateFlow()

    fun seleccionarRol(rol: String) {
        _rolSeleccionado.value = rol
        clearError()
    }

    fun login(usuario: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                println("Iniciando login para usuario: $usuario") // Debug
                val usuarioAutenticado = repository.login(usuario, password)
                _usuarioActual.value = usuarioAutenticado
                println("Login exitoso, usuario autenticado: ${usuarioAutenticado.usuario}")
            } catch (e: Exception) {
                _error.value = e.message
                _usuarioActual.value = null
                println("Error en login: ${e.message}") // Debug
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _error.value = null
    }

    fun logout() {
        _usuarioActual.value = null
        _error.value = null
        _rolSeleccionado.value = null
    }
}

