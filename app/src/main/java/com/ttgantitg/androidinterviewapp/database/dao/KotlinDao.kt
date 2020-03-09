package com.ttgantitg.androidinterviewapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.database.entities.Kotlin
import io.reactivex.Single

@Dao
interface KotlinDao {
    @Query("SELECT * FROM kotlin")
    fun getAll(): Single<List<Kotlin>>
}
