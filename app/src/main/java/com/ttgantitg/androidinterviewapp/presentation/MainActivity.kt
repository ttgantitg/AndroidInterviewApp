package com.ttgantitg.androidinterviewapp.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ttgantitg.androidinterviewapp.R
import com.ttgantitg.androidinterviewapp.databinding.ActivityMainBinding
import com.vorlonsoft.android.rate.AppRate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSharedPref: SharedPreferences
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        checkThemeColor()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupRateDialog()
        setContentView(binding.root)
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
            .setLaunchTimes(1)
            .setRemindInterval(1)
            .setRemindLaunchesNumber(1)
            .setShowLaterButton(true)
            .setThemeResId(R.style.RateDialog)
            .monitor()
        AppRate.showRateDialogIfMeetsConditions(this)
    }

    private fun createNavGraph() {
        val navController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
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
        setupActionBarWithNavController(navController.navController, appBarConfiguration)
        bottom_nav_view?.setupWithNavController(navController.navController)
    }
}
