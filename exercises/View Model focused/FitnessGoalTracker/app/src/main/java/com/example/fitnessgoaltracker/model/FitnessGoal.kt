package com.example.fitnessgoaltracker.model

enum class ActivityType { RUNNING, SWIMMING, CYCLING }

data class FitnessGoal(
    val type: ActivityType,
    val targetKm: Double,
    val currentKm: Double = 0.0
)