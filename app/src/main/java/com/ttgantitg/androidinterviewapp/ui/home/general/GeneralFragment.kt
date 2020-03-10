package com.ttgantitg.androidinterviewapp.ui.home.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ttgantitg.androidinterviewapp.InterviewApplication
import com.ttgantitg.androidinterviewapp.R
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import com.ttgantitg.androidinterviewapp.database.entities.General
import com.ttgantitg.androidinterviewapp.ui.CustomExpandableListAdapter
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class GeneralFragment : Fragment() {

    private lateinit var viewModelFactory: GeneralViewModelFactory
    private lateinit var titleList: List<String>
    private val viewModel: GeneralViewModel by viewModels { viewModelFactory }
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var dataList: TreeMap<String, List<String>> = TreeMap()
    private var generalDataList: List<General> = mutableListOf()

    @Inject
    lateinit var mAppDatabase: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_general, container, false)
        (activity?.application as InterviewApplication).getComponent()?.inject(this)
        viewModelFactory = GeneralViewModelFactory(mAppDatabase.generalDao())
        expandableListView = root.findViewById(R.id.exp_list_view)
        showDataList()
        return root
    }

    private fun showDataList() {
        viewModel.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<General>> {
                override fun onSuccess(t: List<General>) {
                    generalDataList = t
                    prepareDataForExpListView(generalDataList)
                    initExpListView()
                }
                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {}
            })
    }

    private fun prepareDataForExpListView(generalDataList: List<General>) {
        generalDataList.forEach {
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
