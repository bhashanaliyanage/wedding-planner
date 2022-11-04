package com.example.weddingplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weddingplanner.dao.NoteDao
import com.example.weddingplanner.entities.Notes

@Database(
    entities = [Notes::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {

        fun getDatabase(context: Context): NotesDatabase {
            val db = Room.databaseBuilder(
                context, NotesDatabase::class.java, "notes.db"
            ).build()
            return db
        }
    }
}