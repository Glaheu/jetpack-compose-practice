package com.example.composebasics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class TaskManager : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    ) {
                        ImageIcon()
                        TaskCompleteTitle(stringResource(R.string.all_tasks_completed))
                        Comment(stringResource(R.string.nice_work))
                    }
                }
            }
        }
    }
}

@Composable
fun ImageIcon(modifier: Modifier = Modifier) {
    val imageIcon = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = imageIcon,
        contentDescription = null
    )
}

@Composable
fun TaskCompleteTitle(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun Comment(comment: String, modifier: Modifier = Modifier) {
    Text(
        text = comment,
        fontSize = 16.sp
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
ComposeBasicsTheme {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ImageIcon()
        TaskCompleteTitle(stringResource(R.string.all_tasks_completed))
        Comment(stringResource(R.string.nice_work))
    }
}
}