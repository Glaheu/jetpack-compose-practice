package com.example.coursesapp.topics

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourseId: Int,
    val number: Int,
    @DrawableRes val imageResourceId: Int
)
