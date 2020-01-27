package com.raywenderlich.android.creaturemon.app

import android.app.Application
import androidx.room.Room
import com.raywenderlich.android.creaturemon.dagger.component.AppComponent
import com.raywenderlich.android.creaturemon.model.room.CreatureDatabase

class CreaturemonApplication : Application() {

  lateinit var creaturemonApplication: AppComponent

  companion object {
    lateinit var database: CreatureDatabase
  }

  override fun onCreate() {
    super.onCreate()
    database = Room.databaseBuilder(this, CreatureDatabase::class.java, "creature_database").build()
  }
}