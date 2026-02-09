package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme
import kotlinx.coroutines.sync.Mutex

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Title(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HeadBackground(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun Overview(overview: String,modifier: Modifier = Modifier) {
    Text(
        text = overview,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp)
    )
}
@Composable
fun Description(description: String, modifier: Modifier = Modifier) {
    Text(
        text = description,
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun Everything(name: String, overview: String, description: String, modifier: Modifier = Modifier) {
    Column() {
        HeadBackground()
        Title(name)
        Overview(overview)
        Description(description)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
        Everything(stringResource(R.string.jetpack_compose_tutorial),
            stringResource(R.string.overview), stringResource(R.string.description)
        )
    }
}