package com.ttgantitg.androidinterviewapp.di

import android.content.Context
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import com.ttgantitg.androidinterviewapp.database.KotlinDao
import com.ttgantitg.androidinterviewapp.ui.kotlin.KotlinViewModelFactory

object Injection {

    private fun provideUserDataSource(context: Context): KotlinDao {
        val database = AppDatabase.getInstance(context)
        return database.kotlinDao()
    }

    fun provideViewModelFactory(context: Context): KotlinViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return KotlinViewModelFactory(dataSource)
    }
}