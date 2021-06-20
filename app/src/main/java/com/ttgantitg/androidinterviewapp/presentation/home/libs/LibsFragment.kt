package com.ttgantitg.androidinterviewapp.presentation.home.libs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.InterviewApplication
import com.ttgantitg.androidinterviewapp.data.entities.Libs
import com.ttgantitg.androidinterviewapp.databinding.FragmentLibsBinding
import com.ttgantitg.androidinterviewapp.domain.GitRepoState
import com.ttgantitg.androidinterviewapp.presentation.CustomExpandableListAdapter
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class LibsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var libsViewModel: LibsViewModel
    private lateinit var binding: FragmentLibsBinding
    private lateinit var mAdapter: CustomExpandableListAdapter
    private lateinit var titleList: List<String>

    private var dataList: TreeMap<String, List<String>> = TreeMap()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLibsBinding.inflate(inflater, container, false)
        (activity?.application as InterviewApplication).getComponent()?.inject(this)
        libsViewModel = ViewModelProvider(this, viewModelFactory).get(LibsViewModel::class.java)
        initExpListView()
        showDataList()
        return binding.root
    }

    private fun showDataList() {
        libsViewModel.loadLibsData().observe(viewLifecycleOwner, {
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

    private fun prepareDataForExpListView(libsDataList: List<Libs>) {
        libsDataList.forEach {
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
