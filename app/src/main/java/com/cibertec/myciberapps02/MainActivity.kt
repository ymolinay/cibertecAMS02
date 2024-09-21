package com.cibertec.myciberapps02

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.os.postDelayed
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        }

    lateinit var btnSimpleDialog: Button
    lateinit var btnQuestionDialog: Button
    lateinit var btnShowToast: Button
    lateinit var btnProgressDialog: Button
    lateinit var btnSecondScreen: Button
    lateinit var btnSimpleScreen: Button

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSimpleDialog = findViewById(R.id.btnSimpleDialog)
        btnQuestionDialog = findViewById(R.id.btnQuestionDialog)
        btnShowToast = findViewById(R.id.btnShowToast)
        btnProgressDialog = findViewById(R.id.btnProgressDialog)
        btnSecondScreen = findViewById(R.id.btnSecondScreen)
        btnSimpleScreen = findViewById(R.id.btnSimpleScreen)

        btnSimpleDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Título del diálogo")
            builder.setMessage("Este es un mensaje simple.")
            builder.setPositiveButton("Aceptar", null)
            builder.show()
        }

        btnQuestionDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de que deseas continuar?")

            builder.setPositiveButton("Sí") { dialog, which ->
                dialog.cancel()
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.cancel()
            }
            builder.show()
        }

        btnShowToast.setOnClickListener {
            Toast.makeText(this, "Este es un mensaje Toast", Toast.LENGTH_SHORT).show()
        }

        btnProgressDialog.setOnClickListener() {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Cargando...")
            progressDialog.setMessage("Por favor, espere...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            handler.postDelayed({
                progressDialog.dismiss()
            }, 3000)
        }

        btnSecondScreen.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startForResult.launch(intent)
        }

        btnSimpleScreen.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startForResult.launch(intent)
        }
    }

    fun confirmDialog() {
        Toast.makeText(this, "Opción Aceptada", Toast.LENGTH_SHORT).show()
    }

    fun dismissDialog() {
        Toast.makeText(this, "Opción Negativo", Toast.LENGTH_SHORT).show()
    }
}