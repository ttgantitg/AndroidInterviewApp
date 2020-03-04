package com.ttgantitg.androidinterviewapp.ui.java

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.R

class JavaFragment : Fragment() {

    private lateinit var javaViewModel: JavaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        javaViewModel =
            ViewModelProvider(this).get(JavaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_java, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}
