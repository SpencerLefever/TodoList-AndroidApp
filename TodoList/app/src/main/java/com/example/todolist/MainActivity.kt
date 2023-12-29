package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import com.example.todolist.databinding.HomeFragmentContainerBinding
import com.example.views.navigation.HomeFragmentRouter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var homeFragmentContainerBinding: HomeFragmentContainerBinding

    @Inject
    lateinit var homeFragmentRouter: HomeFragmentRouter

    private val navController by lazy {
        Navigation.findNavController(homeFragmentContainerBinding.fragmentNavHost)
    }
    private lateinit var navGraph: NavGraph
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeFragmentContainerBinding = DataBindingUtil.setContentView(this, R.layout.home_fragment_container)

        homeFragmentRouter.show(navController)

//        val graphInflater = navController.navInflater
//        navGraph = graphInflater.inflate(com.example.views.R.navigation.nav_main_graph)
//        navController.setGraph(navGraph, null)
//        navGraph.setStartDestination(R.id.fragment_nav_host)
    }

}