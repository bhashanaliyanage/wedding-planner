package com.example.weddingplanner

import androidx.lifecycle.LiveData

class BudgetCalcRepo(private val budgetDao: BudgetDao) {

    /*Read Function*/
    val allItems: LiveData<List<BudgetBack>> = budgetDao.getAllEntities()

    /*suspend fun insert(budgetBack: BudgetBack) {
        BudgetDao.insert(budgetBack)
    }

    suspend fun delete(budgetBack: BudgetBack) {
        BudgetDao.delete(budgetBack)
    }

    suspend fun update(budgetBack: BudgetBack) {
        BudgetDao.update(budgetBack)t

    }*/
}