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
    @ColumnInfo(name = "taskTypes") var taskTypes: Map<String, Color>
)

class TaskConverter {
    val gson: Gson = Gson()
    @TypeConverter
    fun taskToStoredString(taskList: List<Task>): String {
        return gson.toJson(taskList)
    }

    @TypeConverter
    fun storedStringToTask(taskData: String): List<Task> {
        val listType = object : TypeToken<List<Task?>?>() {}.type
        return gson.fromJson(taskData, listType)
    }

    @TypeConverter
    fun taskEnumToStoredString(taskTypeList: List<String>): String {
        return gson.toJson(taskTypeList)
    }

    @TypeConverter
    fun storedStringToTaskEnum(taskTypeData: String): List<String> {
        val listType = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(taskTypeData, listType)
    }
}

