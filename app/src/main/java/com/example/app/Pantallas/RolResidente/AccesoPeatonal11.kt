package com.example.app.Pantallas.RolResidente

import android.graphics.Bitmap

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.example.app.ui.theme.AzulOscuro
import com.example.app.ui.theme.DoradoElegante
import com.example.app.ui.theme.GrisClaro

@Composable
fun PantallaAccesoPeatonalResidente(navController: NavController) {
    var torreApto by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }
    var quienIngresa by remember { mutableStateOf("") }
    var autorizadoPor by remember { mutableStateOf("") }
    var qrBitmap by remember { mutableStateOf<Bitmap?>(null) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
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
            Text("Acceso Peatonal", fontSize = 20.sp, color = GrisClaro)
        }

        Spacer(modifier = Modifier.height(24.dp))

        CampoAccesoP("Torre - Apartamento", torreApto) { torreApto = it }
        CampoAccesoP("Fecha", fecha) { fecha = it }
        CampoAccesoP("Horario", horario) { horario = it }
        CampoAccesoP("Quién Ingresa", quienIngresa) { quienIngresa = it }
        CampoAccesoP("Autorizado Por", autorizadoPor) { autorizadoPor = it }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val data = """
                    Acceso Peatonal:
                    Torre: $torreApto
                    Fecha: $fecha
                    Hora: $horario
                    Ingresa: $quienIngresa
                    Autorizado por: $autorizadoPor
                """.trimIndent()

                qrBitmap = generarCodigoQR(data)
                Toast.makeText(context, "Acceso creado con éxito", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = DoradoElegante)
        ) {
            Text("Crear Acceso", color = AzulOscuro)
        }

        Spacer(modifier = Modifier.height(24.dp))

        qrBitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Código QR",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(200.dp)
            )
        }
    }
}

fun generarCodigoQR(texto: String): Bitmap {
    val size = 512
    val qrCodeWriter = QRCodeWriter()
    val bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, size, size)
    val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)
    for (x in 0 until size) {
        for (y in 0 until size) {
            bitmap.setPixel(x, y, if (bitMatrix.get(x, y)) Color.Black else Color.White)
        }
    }
    return bitmap
}

private fun Bitmap.setPixel(
    a: kotlin.Int,
    i: kotlin.Int,
    color: androidx.compose.ui.graphics.Color
) {
}

@Composable
fun CampoAccesoP(label: String, valor: String, onChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = label, color = LightGray, fontSize = 12.sp)
        OutlinedTextField(
            value = valor,
            onValueChange = onChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = DoradoElegante,
                unfocusedBorderColor = GrisClaro,
                cursorColor = DoradoElegante
            )
        )
    }
}
