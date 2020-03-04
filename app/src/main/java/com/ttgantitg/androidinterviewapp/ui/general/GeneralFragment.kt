package com.ttgantitg.androidinterviewapp.ui.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.R

class GeneralFragment : Fragment() {

    private lateinit var generalViewModel: GeneralViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generalViewModel =
            ViewModelProvider(this).get(GeneralViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_general, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}
