package com.example.weddingplanner.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "NotesTable")
class Notes : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "title")
    var title: String? = null

    @ColumnInfo(name = "note")
    var note: String? = null

    override fun toString(): String {
    /*He added date and time here for the next line
     * return "$title : $dateTime"*/

        return "$title : $title"
    }
}
