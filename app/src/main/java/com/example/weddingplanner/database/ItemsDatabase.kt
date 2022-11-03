package com.example.weddingplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weddingplanner.dao.BudgetDao
import com.example.weddingplanner.entities.Items

@Database(entities = [Items::class], version = 1, exportSchema = false)
abstract class ItemsDatabase : RoomDatabase() {
    abstract fun budgetDao():BudgetDao
    companion object {

        fun getDatabase(context: Context): ItemsDatabase {
            val db  = Room.databaseBuilder(
                context, ItemsDatabase::class.java, "items.db"
            ).build()
            return db
        }

        /*@Synchronized
        fun getDatabase(context: Context): ItemsDatabase {
            if (itemsDatabase != null) {
                itemsDatabase = Room.databaseBuilder(
                    context, ItemsDatabase::class.java, "items.db"
                ).build()
            }
            return itemsDatabase!!
        }*/
    }
}