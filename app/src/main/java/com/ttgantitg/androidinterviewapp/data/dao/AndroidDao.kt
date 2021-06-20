package com.ttgantitg.androidinterviewapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ttgantitg.androidinterviewapp.data.entities.Android
import io.reactivex.Single

@Dao
interface AndroidDao {
    @Query("SELECT * FROM android")
    suspend fun getAll(): List<Android>
}
