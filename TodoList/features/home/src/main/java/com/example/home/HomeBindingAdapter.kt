package com.example.home
import android.content.Context
import android.graphics.ColorFilter
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.home.databinding.TaskLayoutBinding
import com.example.task.Task
import org.w3c.dom.Text
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Locale

class HomeBindingAdapter(
    private val viewState: HomeViewState,
    private val context: Context,
    private val taskList: MutableList<Task> = viewState.tasks
) : RecyclerView.Adapter<HomeBindingAdapter.HomeViewHolder>(){

    companion object {
        const val TAG = "HomeBindingAdapter"
    }

    private var onDeleteClickListener: OnDeleteClickListener? = null
    private var onCompleteClickListener: OnCompleteClickListener? = null
    private var onExpandClickListener: OnExpandClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_layout, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentTask = taskList[position]
        holder.taskTitle.text = currentTask.title
        val simpleDateFormat = SimpleDateFormat("MM-dd HH:mm", Locale.US)
        holder.dateText.text = simpleDateFormat.format(currentTask.date).toString()

        holder.deleteButton.setOnClickListener {
            if(onDeleteClickListener != null) {
                onDeleteClickListener!!.onClick(position)
            }
        }
        holder.taskCheckBox.setOnClickListener {
            if(onCompleteClickListener != null) {
                onCompleteClickListener!!.onClick(position)
            }
        }
        holder.editButton.setOnClickListener {
            if(onExpandClickListener != null) {
                onExpandClickListener!!.onClick(position)
            }
        }

        val color: Int = currentTask.type?.second ?: R.color.inky
        val drawable = holder.taskLayout.background as GradientDrawable
        drawable.mutate()
        drawable.setStroke(10, color)
    }

    class HomeViewHolder(val view: View) :
        RecyclerView.ViewHolder(view) {
            val taskTitle: TextView = view.findViewById(R.id.task_title)
            val dateText: TextView = view.findViewById(R.id.date_text)
            val deleteButton: Button = view.findViewById(R.id.delete_button)
            val taskCheckBox: CheckBox = view.findViewById(R.id.task_checkbox)
            val editButton: Button = view.findViewById(R.id.edit_button)
            val taskLayout: View = view.findViewById(R.id.task_layout)
    }

    fun setDeleteOnClickListener(onClickListener: OnDeleteClickListener) {
        this.onDeleteClickListener = onClickListener
    }

    fun setCompleteOnClickListener(onClickListener: OnCompleteClickListener) {
        this.onCompleteClickListener = onClickListener
    }

    fun setExpandeOnClickListener(onClickListener: OnExpandClickListener) {
        this.onExpandClickListener = onClickListener
    }

    interface OnDeleteClickListener {
        fun onClick(position: Int)
    }

    interface OnCompleteClickListener {
        fun onClick(position: Int)
    }

    interface OnExpandClickListener {
        fun onClick(position: Int)
    }

}