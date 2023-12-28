package com.example.home

import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.home.databinding.TaskLayoutBinding
import com.example.core.task.Task


fun getTaskList(viewState: HomeViewState) : MutableList<Task> {
    return viewState.tasks
}
class HomeBindingAdapter(
    private val context: Context,
    private val viewState: HomeViewState,
    private val taskList: MutableList<Task> = getTaskList(viewState)
) : RecyclerView.Adapter<HomeBindingAdapter.HomeViewHolder>(){
    private lateinit var listener : OnItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.task_layout,
                parent,
                false
            )
        return HomeViewHolder(binding, listener)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentTask = taskList[position]

        holder.taskTitle.text = currentTask.title
        holder.dateText.text = currentTask.date.toString()
        holder.taskDeleteButton.setOnClickListener {
            listener.onItemClick(position)
        }
        holder.taskCheckBox.setOnClickListener {
            listener.onItemClick(position)
        }
        holder.taskTitle.setOnClickListener {
            listener.onItemClick(position)
        }
        if(holder.taskCheckBox.isChecked) {
            viewState.tasks[position].completed = true
            holder.taskTitle.foreground = AppCompatResources.getDrawable(context, R.drawable.strikethrough_text)
        } else {
            viewState.tasks[position].completed = false
            holder.taskTitle.foreground = null
        }
        val color: Int? = viewState.taskTypeList[currentTask.type.toString()]?.let { context.getColor(it) }
        holder.taskLayout.setBackgroundColor(color ?: context.getColor(R.color.inky))
    }

    class HomeViewHolder(binding: ViewDataBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {
            val view = binding as TaskLayoutBinding
            val taskTitle: TextView = view.taskTitle
            val dateText: TextView = view.dateText
            val taskCheckBox: CheckBox = view.taskCheckbox
            val taskDeleteButton: Button = view.deleteButton
            val taskLayout: ConstraintLayout = view.taskLayout
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

}