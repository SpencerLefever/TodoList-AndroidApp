package com.example.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.task.Task
import com.example.task.TaskTypeEnum
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(tableName = "User")
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "tasks") var tasks: MutableList<Task> = mutableListOf(),
    @ColumnInfo(name = "taskTypes") var taskTypes: Map<String, Int> = mapOf(
        Pair(TaskTypeEnum.WORK.taskType, TaskTypeEnum.WORK.color),
        Pair(TaskTypeEnum.SCHOOL.taskType, TaskTypeEnum.SCHOOL.color),
        Pair(TaskTypeEnum.PERSONAL.taskType, TaskTypeEnum.PERSONAL.color)
    )
)

class TaskConverter {
    val gson: Gson = Gson()
    @TypeConverter
    fun taskToStoredString(taskList: List<Task>?): String? {
        return gson.toJson(taskList)
    }

    @TypeConverter
    fun storedStringToTask(taskData: String?): List<Task>? {
        val listType = object : TypeToken<List<Task>>() {}.type
        return gson.fromJson(taskData, listType)
    }

    @TypeConverter
    fun taskEnumToStoredString(taskTypeList: Map<String, Int>?): String? {
        return gson.toJson(taskTypeList)
    }

    @TypeConverter
    fun storedStringToTaskEnum(taskTypeData: String?): Map<String, Int>? {
        val listType = object : TypeToken<Map<String, Int>>() {}.type
        return gson.fromJson(taskTypeData, listType)
    }
}

