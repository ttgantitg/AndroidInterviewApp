package com.ttgantitg.androidinterviewapp.presentation.home.kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttgantitg.androidinterviewapp.data.dao.KotlinDao
import com.ttgantitg.androidinterviewapp.data.entities.Kotlin
import com.ttgantitg.androidinterviewapp.domain.GitRepoState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class KotlinViewModel @Inject constructor(private val dataSource: KotlinDao) : ViewModel() {

    private var gitReposState: MutableLiveData<GitRepoState<List<Kotlin>>> = MutableLiveData()

    fun loadKotlinData(): MutableLiveData<GitRepoState<List<Kotlin>>> {
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
