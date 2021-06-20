package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.Java

@Dao
interface JavaDao {
    @Query("SELECT * FROM java")
    suspend fun getAll(): List<Java>
}
