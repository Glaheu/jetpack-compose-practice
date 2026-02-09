package com.example.artspaceapp

import android.health.connect.datatypes.ElevationGainedRecord
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import java.time.Year

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GalleryApp(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GalleryApp(name: String, modifier: Modifier = Modifier) {
    var currentPage by remember { mutableStateOf(1) }
    val (imageRes, subjectNameRes, photographerRes) = when (currentPage) {
        1 -> Triple(
            R.drawable.zhu_hongzhi_afijece9jt0_unsplash,
            R.string.monday_blues,
            R.string.zhu_hongzhi
        )

        2 -> Triple(
            R.drawable.coleen_rivas_oz2rs2zcjno_unsplash,
            R.string.super_tree,
            R.string.hu_chen
        )
        else -> Triple(
            R.drawable.anthony_lim_rfghphhp9zq_unsplash,
            R.string.merlion,
            R.string.anthony_lim
        )
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 48.dp)
    ) {
        ArtworkWall(imageRes, subjectNameRes)
        Spacer(modifier = Modifier.height(100.dp))
        ArtworkDescriptor(subjectNameRes, photographerRes, 1)
        Spacer(modifier = Modifier.height(38.dp))
        DisplayController(
            currentPage,
            { newValue ->
                currentPage = newValue
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun ArtworkWall(image: Int, name: Int, modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 6.dp
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(name),
            modifier = Modifier
                .padding(24.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(title: Int, artist: Int, year: Int, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFB3E5FC))
            .padding(12.dp)
    ) {
        Text(
            stringResource(title),
            fontSize = 28.sp
        )
        Text(
            stringResource(artist),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun DisplayController(
    currentPage: Int,
    onPageChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PageButton(
            R.string.previous,
            {
                if (currentPage > 1) onPageChange(currentPage - 1)
            })
        PageButton(
            R.string.next,
            {
                if (currentPage < 3) onPageChange(currentPage + 1)
            }
        )
    }
}

@Composable
fun PageButton(
    text: Int, onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFFC8E6C9)),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.width(125.dp)
    ) {
        Text(
            stringResource(text),
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        GalleryApp("Android")
    }
}