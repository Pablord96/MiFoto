package com.example.mifoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mifoto.ui.theme.MiFotoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiFotoTheme {
                MiFoto()
            }
        }
    }
}

@Composable
fun MiFoto() {
    //Declaramos una variable observable para almacenar el color de fondo
    //val colorFondo = remember {mutableStateOf(Color.Blue)}
    var colorFondo by remember { mutableStateOf(Color.Blue) }
    var posicionTexto by remember { mutableStateOf(Offset(0f, 0f)) }


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        //.background(colorFondo.value))
        .background(colorFondo))
    {
        Image(
            painter = painterResource(R.drawable.philadelphia_eagles_logo_svg),
            contentDescription = "Philadelphia Eagles",
            modifier = Modifier.align(Alignment.Center).fillMaxSize()
        )
        Text(
            text = "Philadelphia Eagles", color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                //.align(Alignment.Center)
                .offset{
                    IntOffset(posicionTexto.x.toInt(),
                        posicionTexto.y.toInt())
                }
                .pointerInput(Unit){
                    detectDragGestures { change, dragAmount ->
                        change.consume()//evita que se activen otros eventos
                        posicionTexto = Offset (
                            posicionTexto.x+dragAmount.x,
                            posicionTexto.y+dragAmount.y
                        )
                    }
                }
                /*.pointerInput(Unit){
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        posicionTexto = posicionTexto.plus(dragAmount)
                    }
                }*/
        )
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            onClick = { colorFondo = colorAleatorio()}
        ) {
            Text(text = "Cambiar Fondo")
        }
    }
}

fun colorAleatorio(): Color {
    val red = (0..255).random()
    val green = (0..255).random()
    val blue = (0..255).random()
    return Color(red, green, blue)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiFotoTheme {
        MiFoto()
    }
}