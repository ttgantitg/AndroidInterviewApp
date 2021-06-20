package com.ttgantitg.androidinterviewapp.di.modules

import android.content.Context
import androidx.room.Room
import com.ttgantitg.androidinterviewapp.data.AppDatabase
import com.ttgantitg.androidinterviewapp.data.dao.*
import com.ttgantitg.androidinterviewapp.di.qualifiers.ApplicationContext
import com.ttgantitg.androidinterviewapp.di.qualifiers.DatabaseInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(@ApplicationContext context: Context) {

    @ApplicationContext
    private val mContext: Context = context

    @DatabaseInfo
    private val mDBName = "interview.db"

    @Singleton
    @Provides
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            mContext,
            AppDatabase::class.java,
            mDBName
        ).fallbackToDestructiveMigration()
         .createFromAsset("databases/$mDBName")
         .build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return mDBName
    }

    @Singleton
    @Provides
    fun provideJavaDao(db: AppDatabase): JavaDao {
        return db.javaDao()
    }

    @Singleton
    @Provides
    fun provideKotlinDao(db: AppDatabase): KotlinDao {
        return db.kotlinDao()
    }

    @Singleton
    @Provides
    fun provideAndroidDao(db: AppDatabase): AndroidDao {
        return db.androidDao()
    }

    @Singleton
    @Provides
    fun provideLibsDao(db: AppDatabase): LibsDao {
        return db.libsDao()
    }

    @Singleton
    @Provides
    fun provideGeneralDao(db: AppDatabase): GeneralDao {
        return db.generalDao()
    }
}