package com.example.jetpackcomponentswithkotlin.repositry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpackcomponentswithkotlin.model.CountryModel
import com.example.jetpackcomponentswithkotlin.retrofit.RetroInstance



class MemesRepository(private val apiInterface:RetroInstance) {
    private val postData=MutableLiveData<CountryModel>()

    val postLiveData:LiveData<CountryModel>

    get()=postData

    suspend fun getPostData(){
        val result=apiInterface.getPostData()
        if(result.body()!=null){
            postData.postValue(result.body())
        }
    }





}