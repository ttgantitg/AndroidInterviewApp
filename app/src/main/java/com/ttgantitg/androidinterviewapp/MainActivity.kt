package com.ttgantitg.androidinterviewapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.vorlonsoft.android.rate.AppRate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        checkThemeColor()
        super.onCreate(savedInstanceState)
        setupRateDialog()
        setContentView(R.layout.activity_main)
        createNavGraph()
    }

    private fun checkThemeColor() {
        mSharedPref = getSharedPreferences("mPref", Context.MODE_PRIVATE)
        if (mSharedPref.getBoolean("NightMode", false)) {
            setTheme(R.style.AppDarkTheme)
        } else {
            setTheme(R.style.AppLightTheme)
        }
    }

    private fun setupRateDialog() {
        AppRate.with(this)
            .setInstallDays(1)
            .setLaunchTimes(3)
            .setRemindInterval(1)
            .setRemindLaunchesNumber(3)
            .setShowLaterButton(true)
            .setThemeResId(R.style.RateDialog)
            .monitor()
        AppRate.showRateDialogIfMeetsConditions(this)
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
