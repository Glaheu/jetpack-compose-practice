package com.example.smarthomedevicemanager.data

import com.example.smarthomedevicemanager.model.DeviceType
import com.example.smarthomedevicemanager.model.SmartDevice


object HomeDataSource {
    val smartDeviceList = listOf(
        SmartDevice(1, "Living Room Light", DeviceType.LIGHT, powerConsumption = 10),
        SmartDevice(2, "Master AC", DeviceType.AC, powerConsumption = 1500),
        SmartDevice(3, "Kitchen Heater", DeviceType.HEATER, powerConsumption = 2000),
        SmartDevice(4, "Hallway Light", DeviceType.LIGHT, powerConsumption = 10),
        SmartDevice(5, "Garden Security", DeviceType.SECURITY, powerConsumption = 50)
    )
}