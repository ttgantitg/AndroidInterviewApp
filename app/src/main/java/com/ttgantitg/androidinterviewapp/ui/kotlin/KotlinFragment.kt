package com.ttgantitg.androidinterviewapp.ui.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.CustomExpandableListAdapter
import com.ttgantitg.androidinterviewapp.R

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

        val redmiMobiles = ArrayList<String>()
        redmiMobiles.add("Redmi Y2")
        redmiMobiles.add("Redmi S2")
        redmiMobiles.add("Redmi Note 5 Pro")
        redmiMobiles.add("Redmi Note 5")
        redmiMobiles.add("Redmi 5 Plus")
        redmiMobiles.add("Redmi Y1")
        redmiMobiles.add("Redmi 3S Plus")

        val micromaxMobiles = ArrayList<String>()
        micromaxMobiles.add("Micromax Bharat Go")
        micromaxMobiles.add("Micromax Bharat 5 Pro")
        micromaxMobiles.add("Micromax Bharat 5")
        micromaxMobiles.add("Micromax Canvas 1")
        micromaxMobiles.add("Micromax Dual 5")

        val appleMobiles = ArrayList<String>()
        appleMobiles.add("iPhone 8")
        appleMobiles.add("iPhone 8 Plus")
        appleMobiles.add("iPhone X")
        appleMobiles.add("iPhone 7 Plus")
        appleMobiles.add("iPhone 7")
        appleMobiles.add("iPhone 6 Plus")

        val samsungMobiles = ArrayList<String>()
        samsungMobiles.add("Samsung Galaxy S9+")
        samsungMobiles.add("Samsung Galaxy Note 7")
        samsungMobiles.add("Samsung Galaxy Note 5 Dual")
        samsungMobiles.add("Samsung Galaxy S8")
        samsungMobiles.add("Samsung Galaxy A8")
        samsungMobiles.add("Samsung Galaxy Note 4")

        dataList["Redmi"] = redmiMobiles
        dataList["Micromax"] = micromaxMobiles
        dataList["Apple"] = appleMobiles
        dataList["Samsung"] = samsungMobiles
    }
}
