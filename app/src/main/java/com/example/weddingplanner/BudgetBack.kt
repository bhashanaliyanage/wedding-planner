package com.example.weddingplanner

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "BudgetEntities"
)
class BudgetBack(
    @ColumnInfo(name = "title") val budgetTitle: String,
    @ColumnInfo(name = "amount") val budgetAmount: Int
) {
    @PrimaryKey(autoGenerate = true) var id = 0
}