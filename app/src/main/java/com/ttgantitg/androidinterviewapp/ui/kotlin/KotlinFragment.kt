package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.R

class KotlinFragment : Fragment() {

    private lateinit var kotlinViewModel: KotlinViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        kotlinViewModel =
            ViewModelProvider(this).get(KotlinViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_kotlin, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}
