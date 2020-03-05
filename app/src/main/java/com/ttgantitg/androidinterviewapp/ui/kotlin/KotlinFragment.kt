package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_kotlin.*

class KotlinFragment : Fragment() {

    private lateinit var kotlinViewModel: KotlinViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        kotlinViewModel = ViewModelProvider(this).get(KotlinViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_kotlin, container, false)


        return root
    }

}
