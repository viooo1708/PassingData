package com.example.passingdata

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etUserName : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLoggin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etUserName = findViewById(R.id.etusername)
        etPassword = findViewById(R.id.password)
        btnLoggin = findViewById(R.id.login_button)

        btnLoggin.setOnClickListener() {

            var intent = Intent(this, WelcomePage::class.java)

            val nUsername = etUserName.text.toString()
            val nPassword = etPassword.text.toString()
            intent.putExtra("username", nUsername)
            intent.putExtra("password", nPassword)

            Log.d("usernamenya : ", nUsername)
            Log.d("passwordnya : ", nPassword)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}