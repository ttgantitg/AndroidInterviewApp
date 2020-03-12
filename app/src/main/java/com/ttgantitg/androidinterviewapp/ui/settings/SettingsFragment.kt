package com.ttgantitg.androidinterviewapp.ui.settings

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.MainActivity
import com.ttgantitg.androidinterviewapp.R

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var mSharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        initThemeSwitch(root)
        return root
    }

    private fun initThemeSwitch(root: View) {
        val mSwitch = root.findViewById<SwitchCompat>(R.id.sw_theme)
        mSharedPref = context!!.getSharedPreferences("mPref", Context.MODE_PRIVATE)
        if (mSharedPref.getBoolean("NightMode", false)) {
            mSwitch.isChecked = true
        }
        mSwitch.setOnCheckedChangeListener { _, isChecked ->
            val editor: SharedPreferences.Editor = mSharedPref.edit()
            when (isChecked) {
                true -> {
                    editor.putBoolean("NightMode", true)
                    editor.apply()
                    restartApp()
                }
                false -> {
                    editor.putBoolean("NightMode", false)
                    editor.apply()
                    restartApp()
                }
            }
        }
    }

    private fun restartApp() {
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}