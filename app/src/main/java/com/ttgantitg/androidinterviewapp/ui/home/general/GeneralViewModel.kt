package com.ttgantitg.androidinterviewapp.ui.home.general

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.database.dao.GeneralDao
import com.ttgantitg.androidinterviewapp.database.entities.General
import io.reactivex.Single

class GeneralViewModel(private val dataSource: GeneralDao) : ViewModel() {
    fun getData(): Single<List<General>> {
        return dataSource.getAll()
    }
}
