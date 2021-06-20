package com.ttgantitg.androidinterviewapp.presentation.settings

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ttgantitg.androidinterviewapp.databinding.FragmentSettingsBinding
import com.ttgantitg.androidinterviewapp.presentation.MainActivity

class SettingsFragment : Fragment() {

    private lateinit var mSharedPref: SharedPreferences
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        initThemeSwitch()
        return binding.root
    }

    private fun initThemeSwitch() {
        mSharedPref = requireContext().getSharedPreferences("mPref", Context.MODE_PRIVATE)
        if (mSharedPref.getBoolean("NightMode", false)) {
            binding.swTheme.isChecked = true
        }
        binding.swTheme.setOnCheckedChangeListener { _, isChecked ->
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