package com.ttgantitg.androidinterviewapp.presentation.home.kotlin

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.data.dao.KotlinDao
import com.ttgantitg.androidinterviewapp.data.entities.Kotlin
import io.reactivex.Single
import javax.inject.Inject

class KotlinViewModel @Inject constructor(private val dataSource: KotlinDao) : ViewModel() {
    fun getData(): Single<List<Kotlin>> {
        return dataSource.getAll()
    }
}
