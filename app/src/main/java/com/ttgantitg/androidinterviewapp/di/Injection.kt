package com.ttgantitg.androidinterviewapp.di

import android.content.Context
import com.ttgantitg.androidinterviewapp.database.AppDatabase
import com.ttgantitg.androidinterviewapp.database.DataDao
import com.ttgantitg.androidinterviewapp.ui.home.java.JavaViewModelFactory
import com.ttgantitg.androidinterviewapp.ui.home.kotlin.KotlinViewModelFactory

object Injection {

    private fun provideUserDataSource(context: Context): DataDao {
        val database = AppDatabase.getInstance(context)
        return database.dataDao()
    }

    fun provideKotlinViewModelFactory(context: Context): KotlinViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return KotlinViewModelFactory(dataSource)
    }

    fun provideJavaViewModelFactory(context: Context): JavaViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return JavaViewModelFactory(dataSource)
    }
}