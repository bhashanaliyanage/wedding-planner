package com.example.weddingplanner.dao

import androidx.room.*
import com.example.weddingplanner.entities.Notes

@Dao
interface NoteDao {
    @Query("SELECT * FROM NotesTable ORDER BY id DESC")
    suspend fun getAllNotes() : List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notes: Notes)

    @Delete
    suspend fun deleteNote(notes: Notes)
}