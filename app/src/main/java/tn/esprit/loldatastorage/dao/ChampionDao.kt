package tn.esprit.loldatastorage.dao

import androidx.room.*
import tn.esprit.leagueoflegendrecyclerview.data.Champion

//TODO 7 "Create the dao for the entity"

@Dao
interface ChampionDao {
    @Insert
    fun insert(champ: Champion)

    @Update
    fun update(champ: Champion)

    @Delete
    fun delete(champ: Champion)

    @Query("SELECT * FROM champions")
    fun getAllChamps(): List<Champion>
}