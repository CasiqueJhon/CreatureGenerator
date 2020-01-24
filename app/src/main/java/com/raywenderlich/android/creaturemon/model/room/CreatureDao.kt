package com.raywenderlich.android.creaturemon.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.raywenderlich.android.creaturemon.model.Creature

@Dao
interface CreatureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(creature: Creature)

    @Delete
    fun clearCreature(vararg creature: Creature)

    @Query("SELECT * FROM creature_table ORDER BY name ASC")
    fun getAllCreatures(): LiveData<List<Creature>>
}