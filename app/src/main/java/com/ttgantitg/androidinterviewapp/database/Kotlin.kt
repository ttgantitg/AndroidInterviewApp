package com.ttgantitg.androidinterviewapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Kotlin (
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "answer") val answer: String
)