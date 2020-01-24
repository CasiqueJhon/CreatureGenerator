package com.raywenderlich.android.creaturemon.model

import androidx.lifecycle.LiveData

interface CreatureRepository {
    fun getAllCreatures(): LiveData<List<Creature>>
    fun saveCreature(creature: Creature)
    fun clearAllCreatures()

}