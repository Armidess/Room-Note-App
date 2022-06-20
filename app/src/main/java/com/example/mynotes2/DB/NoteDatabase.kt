package com.example.mynotes2.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock


@Database(
    entities = [Note::class],
    version =1
)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun getNoteDao() : NoteDao

    companion object{
        @Volatile private var instance : NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also{
                instance = it
            }

        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "notedatabase"
        ).build()
    }
}