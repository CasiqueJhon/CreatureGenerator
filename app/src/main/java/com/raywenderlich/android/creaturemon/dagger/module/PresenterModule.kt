package com.raywenderlich.android.creaturemon.dagger.module

import com.raywenderlich.android.creaturemon.presenter.AllCreaturesContract
import com.raywenderlich.android.creaturemon.presenter.AllCreaturesPresenter
import com.raywenderlich.android.creaturemon.presenter.CreatureContract
import com.raywenderlich.android.creaturemon.presenter.CreaturePresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideCreaturePresenter(): CreatureContract.Presenter = CreaturePresenter()

    fun provideAllCreaturePresenter(): AllCreaturesContract.Presenter = AllCreaturesPresenter()
}