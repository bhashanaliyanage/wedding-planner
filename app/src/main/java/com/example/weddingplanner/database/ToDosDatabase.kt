package com.example.weddingplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weddingplanner.dao.ToDosDao
import com.example.weddingplanner.entities.ToDos

@Database(
    entities = [ToDos::class],
    version = 1,
    exportSchema = false
)
abstract class ToDosDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDosDao

    companion object {
        fun getDatabase(context: Context): ToDosDatabase {
            val db = Room.databaseBuilder(
                context, ToDosDatabase::class.java, "todos.db"
            ).build()
            return db
        }
    }
}