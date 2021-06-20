package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.General
import io.reactivex.Single

@Dao
interface GeneralDao {
    @Query("SELECT * FROM general")
    fun getAll(): Single<List<General>>
}
