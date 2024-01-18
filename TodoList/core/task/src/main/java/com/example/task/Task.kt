package com.example.task

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Task (
    val title: String,
    val description: String,
    val type: Pair<String, Int>?,
    val date: Date,
    var completed: Boolean
) : Parcelable