package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DiceRollerApp() {
    DiceWithButttonAndImage()
}

@Composable
fun DiceWithButttonAndImage(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Create a state for the animation trigger
        var isRolling by remember { mutableStateOf(false) }
        var result by remember { mutableStateOf(1) }

        // 2. The rotation will react whenever isRolling changes
        val rotation by animateFloatAsState(
            targetValue = if (isRolling) 720f else 0f,
            animationSpec = tween(durationMillis = 500),
            // Reset isRolling when animation finishes so it can be clicked again
            finishedListener = { isRolling = false }
        )

        val imageResource = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier
                .rotate(rotation)
                .size(200.dp) // Good to define a size
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Use a Coroutine Scope to handle the "timing" of the roll
        val scope = rememberCoroutineScope()

        Button(onClick = {
            if (!isRolling) { // Prevent double-clicks during animation
                isRolling = true
                result = (1..6).random()
            }
        }) {
            Text(stringResource(R.string.roll))
        }
        Spacer(modifier= Modifier.height(10.dp))
        Text("You rolled a $result!")
    }
}