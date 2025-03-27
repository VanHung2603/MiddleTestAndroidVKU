package com.example.ktgk_studentcode.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(customer: Customer)
    @Query("SELECT * FROM customer")
    fun getAllCustomer(): Flow<List<Customer>>
    @Update
    suspend fun update(customer: Customer): Int
    @Delete
    suspend fun delete(customer: Customer): Int
}