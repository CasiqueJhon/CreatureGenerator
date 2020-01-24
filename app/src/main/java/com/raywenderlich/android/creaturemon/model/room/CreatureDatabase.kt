package com.raywenderlich.android.creaturemon.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.android.creaturemon.model.Creature

@Database(entities = [(Creature::class)], version = 1)
abstract class CreatureDatabase : RoomDatabase() {
  abstract fun creatureDao(): CreatureDao
}