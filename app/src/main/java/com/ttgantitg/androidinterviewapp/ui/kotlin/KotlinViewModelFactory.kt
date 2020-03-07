package com.ttgantitg.androidinterviewapp.ui.kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.database.KotlinDao

class KotlinViewModelFactory(private val dataSource: KotlinDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KotlinViewModel::class.java)) {
            return KotlinViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}