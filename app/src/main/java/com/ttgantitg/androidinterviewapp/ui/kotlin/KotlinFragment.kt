package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.CustomExpandableListAdapter
import com.ttgantitg.androidinterviewapp.R
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class KotlinFragment : Fragment() {

    private lateinit var kotlinViewModel: KotlinViewModel
    private lateinit var titleList: List<String>

    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var dataList: HashMap<String, List<String>> = HashMap()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_kotlin, container, false)
        kotlinViewModel = ViewModelProvider(this).get(KotlinViewModel::class.java)
        kotlinViewModel.getData()
        expandableListView = root.findViewById(R.id.exp_list_view)
        initExpListView()
        return root
    }

    private fun initExpListView() {
        if (expandableListView != null) {
            prepareDataList()
            val listData = dataList
            titleList = ArrayList(listData.keys)
            adapter = context?.let {
                CustomExpandableListAdapter(
                    it,
                    titleList as ArrayList<String>,
                    listData
                )
            }
            expandableListView!!.setAdapter(adapter)
        }
    }

    private fun prepareDataList() {

        kotlinViewModel.kotlinData.observe(this, Observer {
            it.let {
                it.forEach {
                    dataList[it.question] = listOf(it.answer)
                }
            }
        })
    }
}
