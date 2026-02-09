package com.example.smarthomedevicemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smarthomedevicemanager.ui.theme.SmartHomeDeviceManagerTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smarthomedevicemanager.model.DeviceType
import com.example.smarthomedevicemanager.model.SmartDevice
import com.example.smarthomedevicemanager.ui.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartHomeDeviceManagerTheme {
                SmartHomeScreen()
            }
        }
    }
}

@Composable
fun SmartHomeScreen(viewModel: HomeViewModel = viewModel()) {
    val state by viewModel.homeUiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Header & Quick Actions
        Text("My Smart Home", style = MaterialTheme.typography.headlineMedium)

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { viewModel.turnOffAll(DeviceType.LIGHT) },
                modifier = Modifier.weight(1f)
            ) { Text("Lights Off") }

            Button(
                onClick = { viewModel.emergencyPowerCut() },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier.weight(1f)
            ) { Text("Power Cut") }
        }

        // Device Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.devices) { device ->
                DeviceCard(
                    device = device,
                    onToggle = { viewModel.toggleDevice(device.id) }
                )
            }
        }

        // Power Usage Monitor
        PowerMonitor(
            current = state.currentPowerUsage,
            max = state.maxPowerLimit,
            isOverloaded = state.isOverloaded
        )
    }
}

@Composable
fun DeviceCard(device: SmartDevice, onToggle: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (device.isSwitchedOn)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp).fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(device.name, fontWeight = FontWeight.Bold)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("${device.powerConsumption}W", style = MaterialTheme.typography.bodySmall)
                Switch(checked = device.isSwitchedOn, onCheckedChange = { onToggle() })
            }
        }
    }
}

@Composable
fun PowerMonitor(current: Int, max: Int, isOverloaded: Boolean) {
    val progress = (current.toFloat() / max.toFloat()).coerceIn(0f, 1f)
    val color = if (isOverloaded) Color.Red else MaterialTheme.colorScheme.primary

    Card(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("Power Usage", fontWeight = FontWeight.Bold)
                Text("$current / $max W", color = color)
            }
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                color = color,
                trackColor = color.copy(alpha = 0.2f)
            )
            if (isOverloaded) {
                Text(
                    "WARNING: Power Limit Reached",
                    color = Color.Red,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}