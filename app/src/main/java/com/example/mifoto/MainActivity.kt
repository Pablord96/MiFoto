package com.example.mifoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    Box(modifier = Modifier.fillMaxSize().padding(20.dp)){
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
                .align(Alignment.Center))
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Cambiar Fondo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiFotoTheme {
        MiFoto()
    }
}