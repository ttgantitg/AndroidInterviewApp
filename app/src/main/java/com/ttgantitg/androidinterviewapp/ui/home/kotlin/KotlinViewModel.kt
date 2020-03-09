package com.ttgantitg.androidinterviewapp.ui.home.kotlin

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.entities.Kotlin
import com.ttgantitg.androidinterviewapp.database.DataDao
import io.reactivex.Single

class KotlinViewModel(private val dataSource: DataDao) : ViewModel() {
    fun getData(): Single<List<Kotlin>> {
        return dataSource.getAllFromKotlin()
    }
}
