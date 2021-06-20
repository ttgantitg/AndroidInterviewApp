package com.ttgantitg.androidinterviewapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ttgantitg.androidinterviewapp.di.ViewModelFactory
import com.ttgantitg.androidinterviewapp.di.ViewModelKey
import com.ttgantitg.androidinterviewapp.presentation.home.android.AndroidViewModel
import com.ttgantitg.androidinterviewapp.presentation.home.general.GeneralViewModel
import com.ttgantitg.androidinterviewapp.presentation.home.java.JavaViewModel
import com.ttgantitg.androidinterviewapp.presentation.home.kotlin.KotlinViewModel
import com.ttgantitg.androidinterviewapp.presentation.home.libs.LibsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AndroidViewModel::class)
    abstract fun bindAndroidViewModel(androidViewModel: AndroidViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(GeneralViewModel::class)
    abstract fun bindGeneralViewModel(generalViewModel: GeneralViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(JavaViewModel::class)
    abstract fun bindJavaViewModel(javaViewModel: JavaViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(KotlinViewModel::class)
    abstract fun bindKotlinViewModel(kotlinViewModel: KotlinViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(LibsViewModel::class)
    abstract fun bindLibsViewModel(libsViewModel: LibsViewModel?): ViewModel?

    @Binds
    abstract fun bindFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?
}