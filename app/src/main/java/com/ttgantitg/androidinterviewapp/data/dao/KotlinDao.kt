package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.Kotlin

@Dao
interface KotlinDao {
    @Query("SELECT * FROM kotlin")
    suspend fun getAll(): List<Kotlin>
}
