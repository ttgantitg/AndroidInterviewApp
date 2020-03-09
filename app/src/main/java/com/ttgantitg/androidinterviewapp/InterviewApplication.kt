package com.ttgantitg.androidinterviewapp

import android.app.Application
import com.ttgantitg.androidinterviewapp.di.ApplicationComponent
import com.ttgantitg.androidinterviewapp.di.ApplicationModule
import com.ttgantitg.androidinterviewapp.di.DaggerApplicationComponent
import com.ttgantitg.androidinterviewapp.di.DatabaseModule

class InterviewApplication : Application() {

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .databaseModule(DatabaseModule(this))
            .build()
        mApplicationComponent!!.inject(this)
    }

    fun getComponent(): ApplicationComponent? {
        return mApplicationComponent
    }
}