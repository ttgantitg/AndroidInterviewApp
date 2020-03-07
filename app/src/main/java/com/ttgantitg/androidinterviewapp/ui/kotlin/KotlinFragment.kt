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
import com.ttgantitg.androidinterviewapp.database.Kotlin
import com.ttgantitg.androidinterviewapp.di.Injection
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class KotlinFragment : Fragment() {

    private lateinit var viewModelFactory: KotlinViewModelFactory
    private lateinit var titleList: List<String>
    private val viewModel: KotlinViewModel by viewModels { viewModelFactory }
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var dataList: HashMap<String, List<String>> = HashMap()
    private var kotlinDataList: List<Kotlin> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_kotlin, container, false)
        viewModelFactory = Injection.provideViewModelFactory(context!!)
        expandableListView = root.findViewById(R.id.exp_list_view)
        showDataList()
        return root
    }

    private fun showDataList() {
        viewModel.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Kotlin>> {
                override fun onSuccess(t: List<Kotlin>) {
                    kotlinDataList = t
                    prepareDataForExpListView(kotlinDataList)
                    initExpListView()
                }
                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {}
            })
    }

    private fun prepareDataForExpListView(kotlinDataList: List<Kotlin>) {
        kotlinDataList.forEach {
            dataList[it.question] = listOf(it.answer)
        }
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
        expandableListView?.refreshDrawableState()
    }
}
