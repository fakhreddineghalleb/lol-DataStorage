package tn.esprit.loldatastorage.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tn.esprit.leagueoflegendrecyclerview.data.Champion
import tn.esprit.loldatastorage.dao.ChampionDao

//TODO 8 "Create the AppDataBase class"
@Database(entities = [Champion::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun champDao(): ChampionDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "champions")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}


