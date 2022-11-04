package com.example.weddingplanner.dao

import androidx.room.*
import com.example.weddingplanner.entities.Items

@Dao
interface BudgetDao {
    // Budget Calculator
    @Query("SELECT * FROM ItemsTable ORDER BY id DESC")
    suspend fun getAllItems() : List<Items>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(items: Items)

    @Delete
    suspend fun deleteItem(items: Items)

    @Query("SELECT SUM(price) FROM ItemsTable")
    suspend fun getSum() : Int
}