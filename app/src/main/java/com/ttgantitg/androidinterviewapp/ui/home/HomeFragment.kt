package com.ttgantitg.androidinterviewapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ttgantitg.androidinterviewapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        java_button.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_java))
        kotlin_button.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_kotlin))
        android_button.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_android))
        libs_button.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_libs))
        general_button.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_general))
    }
}