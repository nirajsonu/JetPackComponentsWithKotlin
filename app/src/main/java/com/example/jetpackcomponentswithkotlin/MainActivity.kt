package com.example.jetpackcomponentswithkotlin

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcomponentswithkotlin.adapter.RecyclerViewAdapter
import com.example.jetpackcomponentswithkotlin.model.CountryModel
import com.example.jetpackcomponentswithkotlin.retrofit.RetroInstance
import com.example.jetpackcomponentswithkotlin.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var myViewModel: MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)







        val recyclerview=findViewById<RecyclerView>(R.id.recyclerview)

        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setTitle("Kotlin Progress Bar")
        progressDialog.setMessage("Application is loading, please wait")

        progressDialog.show()
        recyclerview.setHasFixedSize(true)
        linearLayoutManager=LinearLayoutManager(this)
        recyclerview.layoutManager=linearLayoutManager
       /* val decorator = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        decorator.setDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.line)!!)
        recyclerview.addItemDecoration(decorator)*/


        val apiInterface = RetroInstance.getRetroFitInstance().getAllPost()

        apiInterface.enqueue(object : retrofit2.Callback<List<CountryModel>?> {
            override fun onResponse(
                call: retrofit2.Call<List<CountryModel>?>,
                response: retrofit2.Response<List<CountryModel>?>
            ) {

                val responsebody = response.body()
                recyclerViewAdapter= RecyclerViewAdapter(applicationContext,responsebody)
                recyclerViewAdapter.notifyDataSetChanged()
                recyclerview.adapter=recyclerViewAdapter

                progressDialog.dismiss()
            }

            override fun onFailure(call: retrofit2.Call<List<CountryModel>?>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                progressDialog.dismiss()
            }
        })


    }


}
