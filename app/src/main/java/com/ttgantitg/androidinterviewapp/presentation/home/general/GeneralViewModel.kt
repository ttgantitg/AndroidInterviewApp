package com.ttgantitg.androidinterviewapp.presentation.home.general

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttgantitg.androidinterviewapp.data.dao.GeneralDao
import com.ttgantitg.androidinterviewapp.data.entities.General
import com.ttgantitg.androidinterviewapp.domain.GitRepoState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GeneralViewModel @Inject constructor(private val dataSource: GeneralDao) : ViewModel() {

    private var gitReposState: MutableLiveData<GitRepoState<List<General>>> = MutableLiveData()

    fun loadGeneralData(): MutableLiveData<GitRepoState<List<General>>> {
        gitReposState.value = GitRepoState.Loading
        viewModelScope.launch {
            viewModelScope.launch(Dispatchers.Default) {
                try {
                    dataSource.getAll().apply {
                        gitReposState.postValue(if (isEmpty()) GitRepoState.EmptyList else GitRepoState.Success(this))
                    }
                } catch (e: Exception) {
                    gitReposState.postValue(GitRepoState.Error)
                }
            }
        }
        return gitReposState
    }
}
