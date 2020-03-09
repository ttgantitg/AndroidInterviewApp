package com.ttgantitg.androidinterviewapp.ui.home.java

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.database.DataDao

class JavaViewModelFactory(private val dataSource: DataDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JavaViewModel::class.java)) {
            return JavaViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}