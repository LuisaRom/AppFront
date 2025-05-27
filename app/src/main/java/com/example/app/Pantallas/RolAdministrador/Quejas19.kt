package com.example.app.Pantallas.RolAdministrador

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.ReportProblem
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaQuejas(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                tint = GrisClaro,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Quejas",
                style = MaterialTheme.typography.headlineSmall,
                color = GrisClaro
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "0 Quejas Nuevas",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        SeccionQueja("Ruido", listOf(), Icons.Default.VolumeUp)
        Spacer(modifier = Modifier.height(16.dp))

        SeccionQueja("Mascota", listOf(), Icons.Default.Pets)
        Spacer(modifier = Modifier.height(16.dp))

        SeccionQueja("Violencia", listOf(), Icons.Default.ReportProblem)
    }
}

@Composable
fun SeccionQueja(
    categoria: String,
    quejas: List<String>,
    icono: ImageVector
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icono,
            contentDescription = categoria,
            tint = DoradoElegante,
            modifier = Modifier.size(35.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = categoria,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )
    }

    Spacer(modifier = Modifier.height(4.dp))

    if (quejas.isEmpty()) {
        Text("Sin quejas registradas", color = Color.Gray, fontSize = 14.sp)
    } else {
        quejas.forEach { texto ->
            QuejaItem(texto) {
                // Acción si hubiera navegación o detalles
            }
        }
    }
}


@Composable
fun QuejaItem(texto: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White.copy(alpha = 0.05f))
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = texto,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}
