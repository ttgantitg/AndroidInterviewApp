package com.ttgantitg.androidinterviewapp.ui.home.libs

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.dao.LibsDao
import com.ttgantitg.androidinterviewapp.database.entities.Libs
import io.reactivex.Single

class LibsViewModel(private val dataSource: LibsDao) : ViewModel() {
    fun getData(): Single<List<Libs>> {
        return dataSource.getAll()
    }
}
