package com.example.practiceclickbehaviour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceclickbehaviour.ui.theme.PracticeClickBehaviourTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeClickBehaviourTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCouter by remember {mutableIntStateOf(0)}

    val (textRes, imageRes, contentDescRes) = when (currentStep) {
        1 -> Triple(R.string.tree, R.drawable.lemon_tree, R.string.select_lemon)
        2 -> Triple(R.string.lemon, R.drawable.lemon_squeeze, R.string.squeeze)
        3 -> Triple(R.string.glass, R.drawable.lemon_drink, R.string.drink)
        else -> Triple(R.string.restart, R.drawable.lemon_restart, R.string.empty_glass)
    }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Lemonade", fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background)
        {
            LemonTextAndImage(textRes,imageRes,contentDescRes,
                {
                    when (currentStep) {
                        1 -> {
                            currentStep = 2
                            squeezeCouter = (2..4).random()
                        }

                        2 -> {
                            squeezeCouter--
                            if (squeezeCouter == 0) {
                                currentStep = 3
                            }
                        }
                        3 -> currentStep = 4
                        4 -> currentStep = 1
                    }
                }
            )
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceInt: Int,
    drawableResourceInt: Int,
    contentDescriptionResourceId: Int,
    onImageClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Image(
                painter = painterResource(drawableResourceInt),
                contentDescription = stringResource(contentDescriptionResourceId),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(textLabelResourceInt))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeApp()
}