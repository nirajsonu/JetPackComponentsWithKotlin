package com.example.jetpackcomponentswithkotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.room.Room
import com.example.jetpackcomponentswithkotlin.MainActivity
import com.example.jetpackcomponentswithkotlin.R
import com.example.jetpackcomponentswithkotlin.databinding.ActivityStartBinding
import com.example.jetpackcomponentswithkotlin.model.ButtonsName
import com.example.jetpackcomponentswithkotlin.observer.Observer
import com.example.jetpackcomponentswithkotlin.room.Student
import com.example.jetpackcomponentswithkotlin.room.StudentDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private lateinit var database:StudentDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityStartBinding.inflate(layoutInflater)
        val view=binding.root
        //setContentView(R.layout.activity_start)

        setContentView(view)

        setupRoomDatabase();

        binding.text1="Get Request"
        binding.text2="Post Request"
        binding.text3="Delete Request"
        binding.text4="Update Request"
        binding.text5="File upload"

        val a=ButtonsName()
        a.name="File Upload"
        binding.text6=a


       /* val get_btn=findViewById<Button>(R.id.get_btn)
        val post_btn=findViewById<Button>(R.id.post_btn)
        val Delete_request=findViewById<Button>(R.id.Delete_request)
        val Update_request=findViewById<Button>(R.id.Update_request)
        val file_request=findViewById<Button>(R.id.file_request)*/


        val get_btn=binding.getBtn
        val post_btn=binding.postBtn
        val Delete_request=binding.DeleteRequest
        val Update_request=binding.UpdateRequest
        val file_request=binding.fileRequest




        lifecycle.addObserver(Observer())


        get_btn.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        })


        post_btn.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,PostActivity::class.java)
            startActivity(intent)
        })

        Delete_request.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,DeleteActivity::class.java)
            startActivity(intent)
        })
        Update_request.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,UpdateActivity::class.java)
            startActivity(intent)
        })
        file_request.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,FileActivity::class.java)
            startActivity(intent)
        })

    }

    private fun setupRoomDatabase() {
        database= StudentDatabase.getDatabase(this)

        GlobalScope.launch {
            database.studentDao().insertStudent(Student(0,"Neeraj",12))
        }

        database.studentDao().getAllStudent().observe(this,{
            Log.d("ROOMDB","onCreate:$it")
        })

    }
}