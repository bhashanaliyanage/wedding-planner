package com.example.weddingplanner

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(BudgetBack::class),
    version = 1,
    exportSchema = false
)
abstract class BudgetCalcDatabase : RoomDatabase() {
    abstract fun getBudgetDao(): BudgetDao

    companion object {
        @Volatile
        private var INSTANCE: BudgetCalcDatabase? = null

        fun getDatabase(context: Context): BudgetCalcDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BudgetCalcDatabase::class.java,
                    "budget_calc_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}