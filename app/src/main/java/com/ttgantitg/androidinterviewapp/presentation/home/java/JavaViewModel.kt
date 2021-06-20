package com.ttgantitg.androidinterviewapp.presentation.home.java

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttgantitg.androidinterviewapp.data.dao.JavaDao
import com.ttgantitg.androidinterviewapp.data.entities.Java
import com.ttgantitg.androidinterviewapp.domain.GitRepoState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class JavaViewModel @Inject constructor(private val dataSource: JavaDao) : ViewModel() {

    private var gitReposState: MutableLiveData<GitRepoState<List<Java>>> = MutableLiveData()

    fun loadJavaData(): MutableLiveData<GitRepoState<List<Java>>> {
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
