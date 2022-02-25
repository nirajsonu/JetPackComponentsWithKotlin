package com.example.jetpackcomponentswithkotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Student::class],version = 1)
abstract class StudentDatabase:RoomDatabase() {


    @TypeConverters(Convertor::class)
    abstract fun studentDao():StudentIntefaceDao


    companion object{
        @Volatile
        private var INSTANCE:StudentDatabase?=null

        fun getDatabase(context:Context):StudentDatabase{
            if(INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context,
                        StudentDatabase::class.java,"studentDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}