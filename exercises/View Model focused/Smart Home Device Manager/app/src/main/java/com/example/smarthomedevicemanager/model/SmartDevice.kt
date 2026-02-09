package com.example.smarthomedevicemanager.model

enum class DeviceType { LIGHT, AC, HEATER, SECURITY }

data class SmartDevice(
    val id: Int,
    val name: String,
    val type: DeviceType,
    val isSwitchedOn: Boolean = false,
    val powerConsumption: Int // in Watts
)