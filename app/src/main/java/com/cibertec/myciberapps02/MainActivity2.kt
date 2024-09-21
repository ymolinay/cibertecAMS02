package com.cibertec.myciberapps02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        studentAdapter = StudentAdapter(getStudentList())
        recyclerView.adapter = studentAdapter
    }

    private fun getStudentList(): List<Student> {
        // Aquí deberías obtener la lista de estudiantes desde tu fuente de datos (API, base de datos, etc.)
        // Por ahora, devolvemos una lista de ejemplo
        return listOf(
            Student("Juan", "Pérez", "https://via.placeholder.com/50"),
            Student("María", "Gómez", "https://picsum.photos/50"),
            // ... más estudiantes
        )
    }

}