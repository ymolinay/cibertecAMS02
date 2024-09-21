package com.cibertec.myciberapps02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity3 : AppCompatActivity() {


    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        listView = findViewById(R.id.listView)

        val studentList = listOf(
            "Juan Pérez",
            "María Gómez",
        )

        val adapter = ArrayAdapter(this, R.layout.item_student_simple, studentList)
        listView.adapter = adapter
    }

}