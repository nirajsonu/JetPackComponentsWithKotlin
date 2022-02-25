package com.example.jetpackcomponentswithkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponentswithkotlin.repositry.MemesRepository

class MyViewModelFactory(private val MemesRepository:MemesRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModelFactory(MemesRepository) as  T
    }
}