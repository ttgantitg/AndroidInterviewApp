package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ttgantitg.androidinterviewapp.CustomExpandableListAdapter
import com.ttgantitg.androidinterviewapp.R
import com.ttgantitg.androidinterviewapp.di.Injection

class KotlinFragment : Fragment() {

    private lateinit var viewModelFactory: KotlinViewModelFactory
    private lateinit var titleList: List<String>
    private val viewModel: KotlinViewModel by viewModels { viewModelFactory }
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var dataList: HashMap<String, List<String>> = HashMap()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_kotlin, container, false)
        viewModelFactory = Injection.provideViewModelFactory(context!!)
        expandableListView = root.findViewById(R.id.exp_list_view)
        prepareDataList()
        initExpListView()
        return root
    }

    private fun initExpListView() {
        if (expandableListView != null) {
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
        viewModel.getData().let {
            it.forEach {
                dataList[it.question] = listOf(it.answer)
            }
        }
    }
}
