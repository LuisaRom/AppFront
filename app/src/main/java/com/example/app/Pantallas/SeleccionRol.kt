package com.example.app.Pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app.ViewModel.UsuarioViewModel
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaSeleccionRol(
    navController: NavHostController,
    usuarioViewModel: UsuarioViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AzulOscuro
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Seleccione su Rol",
                color = GrisClaro,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            BotonRol("Administrador") {
                usuarioViewModel.seleccionarRol("ADMIN")
                navController.navigate("PantallaLogin")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BotonRol("Celador") {
                usuarioViewModel.seleccionarRol("CELADOR")
                navController.navigate("PantallaLogin")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BotonRol("Residente") {
                usuarioViewModel.seleccionarRol("RESIDENTE")
                navController.navigate("PantallaLogin")
            }
        }
    }
}

@Composable
fun BotonRol(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(
            text = texto,
            fontSize = 18.sp,
            color = AzulOscuro
        )
    }
}