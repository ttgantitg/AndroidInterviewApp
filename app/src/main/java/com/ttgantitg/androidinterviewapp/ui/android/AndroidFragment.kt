package com.ttgantitg.androidinterviewapp.ui.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.R

class AndroidFragment : Fragment() {

    private lateinit var androidViewModel: AndroidViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        androidViewModel =
            ViewModelProvider(this).get(AndroidViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_android, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}
