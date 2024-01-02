package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.user.UserDatabase
import com.example.views.databinding.HomeFragmentContainerBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var homeFragmentContainerBinding: HomeFragmentContainerBinding

//    @Inject
//    lateinit var homeFragmentRouter: HomeFragmentRouter
//
//    private val navController by lazy {
//        Navigation.findNavController(homeFragmentContainerBinding.fragmentNavHost)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeFragmentContainerBinding = DataBindingUtil.setContentView(this, com.example.views.R.layout.home_fragment_container)

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
//        val navController = navHostFragment.navController
//        findViewById<BottomNavigationItemView>(R.id.fragment_nav_host)
//            .setupWithNavController(navController)

    }

}