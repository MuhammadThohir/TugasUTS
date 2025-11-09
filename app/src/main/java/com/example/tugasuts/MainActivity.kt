package com.example.tugasuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hubungkan dengan ID di XML
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        // Logic tombol "Kirim"
        btnSubmit.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            when {
                username.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                        password.isEmpty() || confirmPassword.isEmpty() -> {
                    Toast.makeText(this, "Semua input harus diisi!", Toast.LENGTH_SHORT).show()
                }

                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    Toast.makeText(this, "Format email tidak valid!", Toast.LENGTH_SHORT).show()
                }

                password != confirmPassword -> {
                    Toast.makeText(this, "Password tidak sama!", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    val fullName = "$firstName $lastName"
                    Toast.makeText(
                        this,
                        "Pendaftaran berhasil!\nSelamat datang, $fullName",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        // Logic tombol "Batal"
        btnCancel.setOnClickListener {
            etUsername.text.clear()
            etEmail.text.clear()
            etFirstName.text.clear()
            etLastName.text.clear()
            etPassword.text.clear()
            etConfirmPassword.text.clear()
            Toast.makeText(this, "Form telah dikosongkan", Toast.LENGTH_SHORT).show()
        }
    }
}