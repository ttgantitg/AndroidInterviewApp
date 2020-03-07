package com.ttgantitg.androidinterviewapp.ui.kotlin

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.Kotlin
import com.ttgantitg.androidinterviewapp.database.KotlinDao


class KotlinViewModel(private val dataSource: KotlinDao) : ViewModel() {

    fun getData(): List<Kotlin> {
        return dataSource.getAll()
    }
}
