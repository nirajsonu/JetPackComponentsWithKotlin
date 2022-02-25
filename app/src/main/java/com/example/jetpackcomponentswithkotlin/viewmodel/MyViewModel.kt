package com.example.jetpackcomponentswithkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomponentswithkotlin.model.CountryModel
import com.example.jetpackcomponentswithkotlin.repositry.MemesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(private val MemesRepository:MemesRepository): ViewModel() {
    init{
        viewModelScope.launch  (Dispatchers.IO){
            MemesRepository.getPostData()
        }
    }

    val postData:LiveData<CountryModel>
    get() = MemesRepository.postLiveData
}