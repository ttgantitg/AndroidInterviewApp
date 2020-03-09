package com.ttgantitg.androidinterviewapp.ui.home.kotlin

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.dao.KotlinDao
import com.ttgantitg.androidinterviewapp.database.entities.Kotlin
import io.reactivex.Single

class KotlinViewModel(private val dataSource: KotlinDao) : ViewModel() {
    fun getData(): Single<List<Kotlin>> {
        return dataSource.getAll()
    }
}
