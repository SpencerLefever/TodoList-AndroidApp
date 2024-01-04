package com.example.home
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.home.databinding.TaskLayoutBinding
import com.example.task.Task

class HomeBindingAdapter(
    private val taskList: MutableList<Task>
) : RecyclerView.Adapter<HomeBindingAdapter.HomeViewHolder>(){

    companion object {
        const val TAG = "HomeBindingAdapter"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.task_layout,
                parent,
                false
            )
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentTask = taskList[position]

        holder.taskTitle.text = currentTask.title
        holder.dateText.text = currentTask.date.toString()
//        if(holder.taskCheckBox.isChecked) {
//            viewState.tasks[position].completed = true
//            holder.taskTitle.foreground = AppCompatResources.getDrawable(context, com.example.common_libs.R.drawable.strikethrough_text)
//        } else {
//            viewState.tasks[position].completed = false
//            holder.taskTitle.foreground = null
//        }
//        val color: Int? = viewState.taskTypeList[currentTask.type.toString()]?.let { context.getColor(it) }
//        holder.taskLayout.setBackgroundColor(color ?: context.getColor(R.color.inky))
    }

    class HomeViewHolder(binding: ViewDataBinding) :
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

}