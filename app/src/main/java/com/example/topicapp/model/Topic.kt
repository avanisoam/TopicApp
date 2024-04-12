package com.example.topicapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Topic (
    @StringRes val name : Int,
    val numberOfCourses : Int,
    @DrawableRes val imageResource : Int
)