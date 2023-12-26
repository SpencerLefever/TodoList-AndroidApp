package com.example.todolist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel(){

    //TODO fetch user from local db
    val user = User(mutableListOf(), mutableListOf())



}