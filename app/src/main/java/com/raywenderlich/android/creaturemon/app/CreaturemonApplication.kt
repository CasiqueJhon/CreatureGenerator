package com.raywenderlich.android.creaturemon.app

import android.app.Application
import com.raywenderlich.android.creaturemon.model.room.CreatureDatabase

class CreaturemonApplication : Application() {

  companion object {
    lateinit var database: CreatureDatabase
  }

  override fun onCreate() {
    super.onCreate()
    // TODO: init database
  }
}