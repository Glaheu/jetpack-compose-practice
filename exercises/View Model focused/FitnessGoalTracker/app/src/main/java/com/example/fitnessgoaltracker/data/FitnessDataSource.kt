package com.example.fitnessgoaltracker.data

import com.example.fitnessgoaltracker.model.ActivityType
import com.example.fitnessgoaltracker.model.FitnessGoal


object FitnessDataSource {
    val initialGoals = listOf(
        FitnessGoal(ActivityType.RUNNING, 50.0),
        FitnessGoal(ActivityType.SWIMMING, 10.0),
        FitnessGoal(ActivityType.CYCLING, 100.0)
    )
}