package com.example.tasks.addtask

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.databinding.BindingAdapter
import com.example.tasks.R

@BindingAdapter("setTaskRadioGroup")
fun setTaskRadioGroup(radioGroup: RadioGroup, viewState: AddTaskViewState) {
    with(radioGroup) {
        for(item in viewState.taskTypeMap) {
            val radioButton = RadioButton(context)
            radioButton.text = item.key
            radioButton.textSize = 20F
            radioButton.layoutParams
            addView(radioButton)
        }
    }
}