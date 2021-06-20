package com.ttgantitg.androidinterviewapp.presentation.home.java

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.data.dao.JavaDao
import com.ttgantitg.androidinterviewapp.data.entities.Java
import io.reactivex.Single
import javax.inject.Inject

class JavaViewModel @Inject constructor(private val dataSource: JavaDao) : ViewModel() {
    fun getData(): Single<List<Java>> {
        return dataSource.getAll()
    }
}
