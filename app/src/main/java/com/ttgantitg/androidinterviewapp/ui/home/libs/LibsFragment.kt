package com.ttgantitg.androidinterviewapp.ui.home.libs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.R

class LibsFragment : Fragment() {

    private lateinit var libsViewModel: LibsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        libsViewModel =
            ViewModelProvider(this).get(LibsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_libs, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}
