package com.example.fitnessgoaltracker.ui

import androidx.lifecycle.ViewModel
import com.example.fitnessgoaltracker.data.FitnessDataSource
import com.example.fitnessgoaltracker.model.ActivityType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FitnessViewModel : ViewModel() {
    private val _fitnessUiState = MutableStateFlow(FitnessUiState())
    val fitnessUiState = _fitnessUiState.asStateFlow()

    init {
        val data = FitnessDataSource.initialGoals
        _fitnessUiState.update { it.copy(goals = data) }
    }

    fun logProgress(type: ActivityType, km: Double) {
        _fitnessUiState.update { currentState ->
            val updatedSpecificGoalInList = currentState.goals.map { goal ->
                if (goal.type == type) {
                    goal.copy(
                        currentKm = goal.currentKm.plus(km).coerceAtMost(goal.targetKm)
                    )
                } else goal
            }
            currentState.copy(goals = updatedSpecificGoalInList)
        }
    }

    fun resetGoal(type: ActivityType) {
        _fitnessUiState.update { currentState ->
            val resetedGoals = currentState.goals.map { goal ->
                if (goal.type == type) goal.copy(currentKm = 0.0) else goal
            }
            currentState.copy(goals = resetedGoals)
        }
    }

    fun updateTarget(type: ActivityType, newTarget: Double) {
        _fitnessUiState.update { currentState ->
            val updatedGoals = currentState.goals.map { goal ->
                if (goal.type == type) goal.copy(
                    targetKm = newTarget,
                    currentKm = goal.currentKm.coerceAtMost(newTarget)
                ) else goal
            }
            currentState.copy(goals = updatedGoals)
        }
    }
}