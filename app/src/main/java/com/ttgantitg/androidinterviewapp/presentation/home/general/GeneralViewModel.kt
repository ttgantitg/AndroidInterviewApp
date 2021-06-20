package com.ttgantitg.androidinterviewapp.presentation.home.general

import androidx.lifecycle.ViewModel
import com.ttgantitg.androidinterviewapp.data.dao.GeneralDao
import com.ttgantitg.androidinterviewapp.data.entities.General
import io.reactivex.Single
import javax.inject.Inject

class GeneralViewModel @Inject constructor(private val dataSource: GeneralDao) : ViewModel() {
    fun getData(): Single<List<General>> {
        return dataSource.getAll()
    }
}
