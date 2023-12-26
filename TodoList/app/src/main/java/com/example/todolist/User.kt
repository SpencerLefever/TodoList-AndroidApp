package com.example.todolist

import com.example.tasks.Task
import com.example.tasks.TaskTypeEnum
import java.util.Collections


//TODO implement sql and add Entity annotation
data class User(
    var tasks: MutableList<Task>,
    var taskTypes: MutableList<TaskTypeEnum>
)

fun User.addTask(task: Task) {
    tasks.add(task)
}

fun User.removeTask(task: Task) {
    tasks.remove(task)
}
fun User.moveTask(task: Task, index: Int) {
    removeTask(task)
    tasks.add(index, task)
}

fun User.swapTasks(index1: Int, index2: Int) {
    Collections.swap(tasks, index1, index2)
}

fun User.getTaskByIndex(index: Int): Task {
    return tasks[index]
}

fun User.getTaskByTitle(title: String): List<Task> {
    return tasks.filter { it.title == title }
}

fun User.getTasksByType(type: String): List<Task> {
    return tasks.filter { it.type == type}
}

