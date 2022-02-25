package com.example.jetpackcomponentswithkotlin.observer

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer:LifecycleObserver {
//val context:Context = TODO()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.d("Main:","onCreate:Observer")
       // Toast.makeText(context,"Welcome to Retrofit kotlin",Toast.LENGTH_LONG).show()
    }


}