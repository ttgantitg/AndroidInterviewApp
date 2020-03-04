package com.ttgantitg.androidinterviewapp.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface KotlinDao {
    @Query("SELECT * FROM kotlin")
    fun getAll(): List<Kotlin>
}
