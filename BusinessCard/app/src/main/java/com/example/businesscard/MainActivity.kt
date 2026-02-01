package com.example.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                val cardImg = painterResource(R.drawable.android_logo)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray // Set the desired background color
                )  {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.weight(7f))
                        MainCard(cardImg, "Lennel Sng", "Student")
                        Spacer(Modifier.weight(5f))
                        ContactInformation("+65 8826 4272", "@lennnnnnnnnnnnnnnel", "lennelsng@gmail.com")
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun MainCard(
    image: Painter,
    name: String,
    title: String,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier.size(100.dp,100.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = title, fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInformation(number: String, social: String, email: String) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        ContactRow(painterResource(R.drawable.outline_phone_in_talk_24), number)
        ContactRow(painterResource(R.drawable.outline_alternate_social_24), social)
        ContactRow(painterResource(R.drawable.outline_mail_24), email)
    }
}

@Composable
fun ContactRow(icon: Painter, subject: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = icon,
            contentDescription = null
        )
        Text(
            text = subject,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        val cardImg = painterResource(R.drawable.android_logo)
        Surface(Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.weight(7f))
                MainCard(cardImg, "Lennel Sng", "Student")
                Spacer(Modifier.weight(5f))
                ContactInformation("+65 8826 4272", "@lennnnnnnnnnnnnnnel", "lennelsng@gmail.com")
                Spacer(Modifier.weight(1f))
            }
        }
    }
}