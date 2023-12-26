package com.example.tasks

import android.content.Context
import android.graphics.Color
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.marginTop
import androidx.databinding.BindingAdapter

@BindingAdapter("setTaskRadioGroup")
fun setTaskRadioGroup(radioGroup: RadioGroup, viewState: AddTaskViewState) {
    with(radioGroup) {
        for(item in viewState.taskTypeList) {
            val radioButton = RadioButton(context)
            radioButton.text = item.taskType
            radioButton.textSize = 20F
            radioButton.setTextColor(resources.getColor(R.color.inky, null))
            radioButton.layoutParams
            addView(radioButton)
        }
    }
}