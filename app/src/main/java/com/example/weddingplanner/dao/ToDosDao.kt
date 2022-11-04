package com.example.weddingplanner.dao

import androidx.room.*
import com.example.weddingplanner.entities.ToDos

@Dao
interface ToDosDao {
    // Budget Calculator
    @Query("SELECT * FROM ToDosTable ORDER BY id DESC")
    suspend fun getAllToDos() : List<ToDos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(toDos: ToDos)

    @Delete
    suspend fun deleteToDo(toDos: ToDos)
}