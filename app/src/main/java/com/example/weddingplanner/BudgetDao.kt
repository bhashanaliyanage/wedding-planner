package com.example.weddingplanner

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BudgetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(budgetBack: BudgetBack)

    @Update
    suspend fun update(budgetBack: BudgetBack)

    @Delete
    suspend fun delete(budgetBack: BudgetBack)

    /*Read Method*/
    @Query("select * from BudgetEntities order by id ASC")
    fun getAllEntities(): LiveData<List<BudgetBack>>
}