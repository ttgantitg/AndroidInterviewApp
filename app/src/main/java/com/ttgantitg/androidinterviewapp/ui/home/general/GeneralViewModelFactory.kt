package com.ttgantitg.androidinterviewapp.ui.home.general

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.database.dao.GeneralDao

class GeneralViewModelFactory(private val dataSource: GeneralDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GeneralViewModel::class.java)) {
            return GeneralViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}