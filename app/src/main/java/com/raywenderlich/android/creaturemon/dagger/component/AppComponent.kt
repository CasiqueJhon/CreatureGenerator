package com.raywenderlich.android.creaturemon.dagger.component

import com.raywenderlich.android.creaturemon.dagger.module.AppModule
import com.raywenderlich.android.creaturemon.dagger.module.PresenterModule
import com.raywenderlich.android.creaturemon.view.allcreatures.AllCreaturesActivity
import com.raywenderlich.android.creaturemon.view.creature.CreatureActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface AppComponent {

    fun inject(target: CreatureActivity)

    fun inject(target: AllCreaturesActivity)
}