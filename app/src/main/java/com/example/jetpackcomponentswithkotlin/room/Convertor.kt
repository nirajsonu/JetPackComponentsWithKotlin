package com.example.jetpackcomponentswithkotlin.room

import androidx.room.TypeConverter
import java.util.*

class Convertor {

    @TypeConverter
    fun fromDateToLong(date: Date):Long{
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(long: Long):Date{
        return Date(long)
    }

}