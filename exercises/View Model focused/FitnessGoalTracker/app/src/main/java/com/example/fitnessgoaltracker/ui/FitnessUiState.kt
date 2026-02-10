package com.example.fitnessgoaltracker.ui

import com.example.fitnessgoaltracker.model.FitnessGoal

data class FitnessUiState(
    val goals: List<FitnessGoal> = emptyList(),
    val userName: String = ""
) {
    val overallProgress
        get() = if (goals.isEmpty()) 0.0 else goals.sumOf { it.currentKm / it.targetKm } / goals.size

    val isEliteAthlete
        get() = goals.isNotEmpty() && goals.all { it.currentKm >= it.targetKm }

    val totalKmRemaining
        get() = goals.sumOf { it.targetKm - it.currentKm }
}
