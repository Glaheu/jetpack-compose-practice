package com.example.smarthomedevicemanager.ui

import com.example.smarthomedevicemanager.model.SmartDevice

data class HomeUiState(
    val devices: List<SmartDevice> = emptyList(),
    val maxPowerLimit: Int = 3000
) {
    val currentPowerUsage: Int
        get() = devices.sumOf {
            if (it.isSwitchedOn)
                it.powerConsumption
            else
                0
        }
    
    val activeDeviceCount
        get() = devices.count {
            it.isSwitchedOn
        }

    val isOverloaded: Boolean
        get() = currentPowerUsage > maxPowerLimit
}
