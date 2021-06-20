package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.General

@Dao
interface GeneralDao {
    @Query("SELECT * FROM general")
    suspend fun getAll(): List<General>
}
