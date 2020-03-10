package com.ttgantitg.androidinterviewapp.ui.home.android

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
import com.ttgantitg.androidinterviewapp.database.entities.Android
import com.ttgantitg.androidinterviewapp.ui.CustomExpandableListAdapter
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class AndroidFragment : Fragment() {

    private lateinit var viewModelFactory: AndroidViewModelFactory
    private lateinit var titleList: List<String>
    private val viewModel: AndroidViewModel by viewModels { viewModelFactory }
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var dataList: TreeMap<String, List<String>> = TreeMap()
    private var androidDataList: List<Android> = mutableListOf()

    @Inject
    lateinit var mAppDatabase: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_android, container, false)
        (activity?.application as InterviewApplication).getComponent()?.inject(this)
        viewModelFactory = AndroidViewModelFactory(mAppDatabase.androidDao())
        expandableListView = root.findViewById(R.id.exp_list_view)
        showDataList()
        return root
    }

    private fun showDataList() {
        viewModel.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Android>> {
                override fun onSuccess(t: List<Android>) {
                    androidDataList = t
                    prepareDataForExpListView(androidDataList)
                    initExpListView()
                }
                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {}
            })
    }

    private fun prepareDataForExpListView(androidDataList: List<Android>) {
        androidDataList.forEach {
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
