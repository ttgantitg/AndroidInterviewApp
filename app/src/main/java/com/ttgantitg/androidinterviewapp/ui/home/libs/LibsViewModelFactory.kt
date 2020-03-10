package com.ttgantitg.androidinterviewapp.ui.home.libs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.database.dao.LibsDao

class LibsViewModelFactory(private val dataSource: LibsDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LibsViewModel::class.java)) {
            return LibsViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}