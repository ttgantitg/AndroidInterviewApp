package com.ttgantitg.androidinterviewapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ttgantitg.androidinterviewapp.R
import com.ttgantitg.androidinterviewapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.javaButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_java))
        binding.kotlinButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_kotlin))
        binding.androidButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_android))
        binding.libsButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_libs))
        binding.generalButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_navigation_general))
    }
}