package com.ttgantitg.androidinterviewapp.presentation.home.libs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttgantitg.androidinterviewapp.data.dao.LibsDao
import com.ttgantitg.androidinterviewapp.data.entities.Libs
import com.ttgantitg.androidinterviewapp.domain.GitRepoState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LibsViewModel @Inject constructor(private val dataSource: LibsDao) : ViewModel() {

    private var gitReposState: MutableLiveData<GitRepoState<List<Libs>>> = MutableLiveData()

    fun loadLibsData(): MutableLiveData<GitRepoState<List<Libs>>> {
        gitReposState.value = GitRepoState.Loading
        viewModelScope.launch(Dispatchers.Default) {
            try {
                dataSource.getAll().apply {
                    gitReposState.postValue(if (isEmpty()) GitRepoState.EmptyList else GitRepoState.Success(this))
                }
            } catch (e: Exception) {
                gitReposState.postValue(GitRepoState.Error)
            }
        }
        return gitReposState
    }
}
