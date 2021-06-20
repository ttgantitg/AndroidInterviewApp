package com.ttgantitg.androidinterviewapp.presentation.home.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttgantitg.androidinterviewapp.data.dao.AndroidDao
import com.ttgantitg.androidinterviewapp.data.entities.Android
import com.ttgantitg.androidinterviewapp.domain.GitRepoState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AndroidViewModel @Inject constructor(private val dataSource: AndroidDao) : ViewModel() {

    private var gitReposState: MutableLiveData<GitRepoState<List<Android>>> = MutableLiveData()

    fun loadAndroidData(): MutableLiveData<GitRepoState<List<Android>>> {
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
