package com.ttgantitg.androidinterviewapp.ui.home.java

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.DataDao
import com.ttgantitg.androidinterviewapp.database.entities.Java
import io.reactivex.Single

class JavaViewModel(private val dataSource: DataDao) : ViewModel() {
    fun getData(): Single<List<Java>> {
        return dataSource.getAllFromJava()
    }
}
