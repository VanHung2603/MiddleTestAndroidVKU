package com.example.ktgk_studentcode.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class CustomerDB: RoomDatabase(){
    abstract fun customerDao(): CustomerDao

    companion object{
        @Volatile
        private var INSTANCE: CustomerDB? = null
        fun getDatabase(context: Context): CustomerDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CustomerDB::class.java,
                    "CustomerDB"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}