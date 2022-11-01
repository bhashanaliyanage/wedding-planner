package com.example.weddingplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weddingplanner.dao.BudgetDao
import com.example.weddingplanner.entities.Items

@Database(entities = [Items::class], version = 1, exportSchema = false)
abstract class ItemsDatabase : RoomDatabase() {
    companion object {
        var itemsDatabase: ItemsDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): ItemsDatabase {
            if (itemsDatabase != null) {
                itemsDatabase = Room.databaseBuilder(
                    context, ItemsDatabase::class.java, "items.db"
                ).build()
            }
            return itemsDatabase!!
        }
    }
    abstract fun budgetDao():BudgetDao
}