package com.gl.app.pet.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.gl.app.pet.R
import com.gl.app.pet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Get the NavHostFragment
        val host =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment

        // Get the NavController
        mNavController = host.navController

        // AppBar Configuration
        val appBarConfiguration = AppBarConfiguration.Builder(R.id.fragment_home).build()
        NavigationUI.setupWithNavController(
            mBinding.topAppBar,
            mNavController,
            appBarConfiguration
        )
    }
}