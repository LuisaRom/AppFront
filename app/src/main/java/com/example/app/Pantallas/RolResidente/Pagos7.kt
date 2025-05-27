package com.example.app.Pantallas.RolResidente

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app.R
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaPagos(navController: NavController) {
    val context = LocalContext.current
    var metodoSeleccionado by remember { mutableStateOf("EFECTIVO") }

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
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Pagos", color = Color.White, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Campo("Torre - Apartamento", " ")
        Campo("Nombre", " ")
        Campo("Id", " ")
        Campo("Fecha", " ")
        Campo("Monto", " ")

        Spacer(modifier = Modifier.height(24.dp))
        Text("Método de Pago", color = Color.White)

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            MetodoPagoItem(
                tipo = "EFECTIVO",
                seleccionado = metodoSeleccionado == "EFECTIVO",
                modifier = Modifier.weight(1f)
            ) {
                metodoSeleccionado = "EFECTIVO"
                Toast.makeText(context, "Recibo generado en PDF", Toast.LENGTH_SHORT).show()
            }

            MetodoPagoItem(
                tipo = "EN LINEA",
                seleccionado = metodoSeleccionado == "EN LINEA",
                modifier = Modifier.weight(1f)
            ) {
                metodoSeleccionado = "EN LINEA"
                Toast.makeText(context, "Redirigiendo a PSE", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun MetodoPagoItem(
    tipo: String,
    seleccionado: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val fondo = if (seleccionado) DoradoElegante else DoradoElegante
    Column(
        modifier = modifier
            .height(115.dp)
            .background(fondo, RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = if (tipo == "EFECTIVO") R.drawable.money else R.drawable.pay),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
        Text(tipo, color = Color.White, fontWeight = FontWeight.Bold)
        Text(
            if (tipo == "EFECTIVO") "Opcion 1" else "Opcion 2",
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun Campo(label: String, valor: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = label, color = GrisClaro, fontSize = 12.sp)
        Text(
            text = valor,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.05f), RoundedCornerShape(6.dp))
                .padding(12.dp)
        )
    }
}