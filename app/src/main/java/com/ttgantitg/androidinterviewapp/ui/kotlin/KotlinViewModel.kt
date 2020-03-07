package com.ttgantitg.androidinterviewapp.ui.kotlin

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.Kotlin
import com.ttgantitg.androidinterviewapp.database.KotlinDao
import io.reactivex.Single


class KotlinViewModel(private val dataSource: KotlinDao) : ViewModel() {

    fun getData(): Single<List<Kotlin>> {
        return dataSource.getAll()
    }
}
