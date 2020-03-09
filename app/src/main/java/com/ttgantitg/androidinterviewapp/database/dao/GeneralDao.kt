package com.ttgantitg.androidinterviewapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.database.entities.General
import io.reactivex.Single

@Dao
interface GeneralDao {
    @Query("SELECT * FROM general")
    fun getAll(): Single<List<General>>
}
