package com.example.jetpackcomponentswithkotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentIntefaceDao {

    @Insert
    suspend fun insertStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("select * from student")
     fun getAllStudent():LiveData<List<Student>>




}