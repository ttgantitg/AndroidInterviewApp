package com.ttgantitg.androidinterviewapp.ui.home.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.database.dao.AndroidDao

class AndroidViewModelFactory(private val dataSource: AndroidDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AndroidViewModel::class.java)) {
            return AndroidViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}