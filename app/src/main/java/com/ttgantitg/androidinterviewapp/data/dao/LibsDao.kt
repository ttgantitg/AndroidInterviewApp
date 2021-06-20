package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.Libs

@Dao
interface LibsDao {
    @Query("SELECT * FROM libs")
    suspend fun getAll(): List<Libs>
}
