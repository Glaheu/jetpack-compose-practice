package com.example.smarthomedevicemanager.ui

import androidx.compose.runtime.currentComposer
import androidx.lifecycle.ViewModel
import com.example.smarthomedevicemanager.data.HomeDataSource
import com.example.smarthomedevicemanager.model.DeviceType
import com.example.smarthomedevicemanager.model.SmartDevice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    private val deviceList = HomeDataSource.smartDeviceList

    init {
        _homeUiState.update {
            it.copy(
                devices = deviceList
            )
        }
    }

    fun toggleDevice(deviceId: Int) {
        _homeUiState.update { currentState ->
            val device = deviceList.find { it.id == deviceId } ?: return@update currentState

            val isTurningOn = !device.isSwitchedOn
            val willExceedLimit =
                currentState.currentPowerUsage + device.powerConsumption > currentState.maxPowerLimit
            if (isTurningOn && willExceedLimit) {
                currentState
            } else {
                val newList = currentState.devices.map {
                    if (it.id == deviceId) {
                        it.copy(
                            isSwitchedOn = !it.isSwitchedOn
                        )
                    } else it
                }
                currentState.copy(devices = newList)
            }
        }
    }

    fun turnOffAll(type: DeviceType) {
        _homeUiState.update { currentState ->
            val newList = currentState.devices.map { currentDevice ->
                if (currentDevice.type == type) {
                    currentDevice.copy(
                        isSwitchedOn = false
                    )
                } else currentDevice
            }
            currentState.copy(devices = newList)
        }
    }

    fun emergencyPowerCut() {
        _homeUiState.update { currentState ->
            val devicesListPowercut = currentState.devices.map { currentDevice ->
                currentDevice.copy(
                    isSwitchedOn = false
                )
            }
            currentState.copy(
                devices = devicesListPowercut
            )
        }
    }
}