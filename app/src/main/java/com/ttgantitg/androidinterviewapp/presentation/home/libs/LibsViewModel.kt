package com.ttgantitg.androidinterviewapp.presentation.home.libs

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.data.dao.LibsDao
import com.ttgantitg.androidinterviewapp.data.entities.Libs
import io.reactivex.Single
import javax.inject.Inject

class LibsViewModel @Inject constructor(private val dataSource: LibsDao) : ViewModel() {
    fun getData(): Single<List<Libs>> {
        return dataSource.getAll()
    }
}
