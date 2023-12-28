package com.example.core.user

import android.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.core.task.Task
import com.example.core.task.TaskTypeEnum
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Collections


//TODO implement sql and add Entity annotation
@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "tasks") var tasks: MutableList<Task>,
    @ColumnInfo(name = "taskTypes") var taskTypes: Map<String, Int>
)

class TaskConverter {
    val gson: Gson = Gson()
    @TypeConverter
    fun taskToStoredString(taskList: List<Task>): String {
        return gson.toJson(taskList)
    }

    @TypeConverter
    fun storedStringToTask(taskData: String): List<Task> {
        val listType = object : TypeToken<List<Task>>() {}.type
        return gson.fromJson(taskData, listType)
    }

    @TypeConverter
    fun taskEnumToStoredString(taskTypeList: Map<String, Int>): String {
        return gson.toJson(taskTypeList)
    }

    @TypeConverter
    fun storedStringToTaskEnum(taskTypeData: String): Map<String, Int> {
        val listType = object : TypeToken<Map<String, Int>>() {}.type
        return gson.fromJson(taskTypeData, listType)
    }
}

