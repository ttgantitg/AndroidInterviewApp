package com.ttgantitg.androidinterviewapp.presentation.home.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.InterviewApplication
import com.ttgantitg.androidinterviewapp.data.entities.Android
import com.ttgantitg.androidinterviewapp.databinding.FragmentAndroidBinding
import com.ttgantitg.androidinterviewapp.domain.GitRepoState
import com.ttgantitg.androidinterviewapp.presentation.CustomExpandableListAdapter
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class AndroidFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var androidViewModel: AndroidViewModel
    private lateinit var binding: FragmentAndroidBinding
    private lateinit var mAdapter: CustomExpandableListAdapter
    private lateinit var titleList: List<String>

    private var dataList: TreeMap<String, List<String>> = TreeMap()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAndroidBinding.inflate(inflater, container, false)
        (activity?.application as InterviewApplication).getComponent()?.inject(this)
        androidViewModel = ViewModelProvider(this, viewModelFactory).get(AndroidViewModel::class.java)
        initExpListView()
        showDataList()
        return binding.root
    }

    private fun showDataList() {
        androidViewModel.loadAndroidData().observe(viewLifecycleOwner, {
            when (it) {
                is GitRepoState.Success -> {
                    prepareDataForExpListView(it.data)
                    binding.progressBar.visibility = View.GONE
                }
                is GitRepoState.Error -> {
                    binding.progressBar.visibility = View.GONE
                }
                is GitRepoState.EmptyList -> {
                    binding.progressBar.visibility = View.GONE
                }
                is GitRepoState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun prepareDataForExpListView(androidDataList: List<Android>) {
        androidDataList.forEach {
            dataList[it.question] = listOf(it.answer)
        }
        val listData = dataList
        titleList = ArrayList(listData.keys)
        mAdapter.submitList(titleList as ArrayList<String>, listData)
    }

    private fun initExpListView() {
        mAdapter = CustomExpandableListAdapter(requireContext())
        binding.expListView.setAdapter(mAdapter)
    }
}
