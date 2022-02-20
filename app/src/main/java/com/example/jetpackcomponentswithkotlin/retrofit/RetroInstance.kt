package com.example.jetpackcomponentswithkotlin.retrofit

import com.example.jetpackcomponentswithkotlin.model.CountryModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface RetroInstance{


    @GET("posts")
    fun getAllPost(): Call<List<CountryModel>>


    @GET("/posts")
    suspend fun getPostData():Response<CountryModel>


    @POST("")
    fun AddPost(id:String,name:String):Call<CountryModel>



    companion object{

        val BASE_URL="https://jsonplaceholder.typicode.com/"


        fun getRetroFitInstance(): RetroInstance {
           val retrofit=Retrofit.Builder()
               .addConverterFactory(GsonConverterFactory.create())
               .baseUrl(BASE_URL)
               .build()
            return retrofit.create(RetroInstance::class.java)
        }

    }
}

