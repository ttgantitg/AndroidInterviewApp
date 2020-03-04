package com.ttgantitg.androidinterviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNavGraph()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "interview.db"
        ).build()

    }

    private fun createNavGraph() {
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_settings,
                R.id.navigation_java,
                R.id.navigation_kotlin,
                R.id.navigation_android,
                R.id.navigation_libs,
                R.id.navigation_general
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottom_nav_view?.setupWithNavController(navController)
    }
}
