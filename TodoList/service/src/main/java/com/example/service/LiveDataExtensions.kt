package com.example.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LiveDataEventWrapper<out T: Any>(private val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if(hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

typealias MutableLiveEvent<T> = MutableLiveData<LiveDataEventWrapper<T>>

typealias LiveEvent<T>  = LiveData<LiveDataEventWrapper<T>>

fun <T: Any> MutableLiveEvent<T>.emit(value: T) {
    this.value = LiveDataEventWrapper(value)
}

fun <T: Any> MutableLiveEvent<T>.postEmit(value: T) {
    this.postValue(LiveDataEventWrapper(value))
}

fun <T: Any> MutableLiveData<T>.asLiveData(): LiveData<T> {
    return this
}
