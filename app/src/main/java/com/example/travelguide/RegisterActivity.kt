package com.example.travelguide

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fullNameEditText: TextInputEditText = findViewById(R.id.fullNameEditText)
        val emailEditText: TextInputEditText = findViewById(R.id.emailEditText)
        val usernameEditText: TextInputEditText = findViewById(R.id.usernameEditText)
        val passwordEditText: TextInputEditText = findViewById(R.id.passwordEditText)
        val confirmPasswordEditText: TextInputEditText = findViewById(R.id.confirmPasswordEditText)
        val createAccountButton: MaterialButton = findViewById(R.id.createAccountButton)
        val backToLoginTextView: android.widget.TextView = findViewById(R.id.backToLoginTextView)

        // Configurar animação do botão
        setupButtonAnimation(createAccountButton)

        createAccountButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (validateRegistration(fullName, email, username, password, confirmPassword)) {
                // Salvar usuário (simulação)
                saveUser(username, password, email, fullName)
                
                showToast("Conta criada com sucesso!")
                
                // Navegar para login
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        backToLoginTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupButtonAnimation(button: MaterialButton) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                android.view.MotionEvent.ACTION_DOWN -> {
                    v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).start()
                }
                android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start()
                }
            }
            false
        }
    }

    private fun validateRegistration(
        fullName: String,
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        if (fullName.isEmpty()) {
            showToast("Por favor, digite seu nome completo")
            return false
        }

        if (email.isEmpty()) {
            showToast("Por favor, digite seu email")
            return false
        }

        if (!isValidEmail(email)) {
            showToast("Email inválido")
            return false
        }

        if (username.isEmpty()) {
            showToast("Por favor, digite seu nome de usuário")
            return false
        }

        if (username.length < 3) {
            showToast("Nome de usuário muito curto (mínimo 3 caracteres)")
            return false
        }

        if (password.isEmpty()) {
            showToast("Por favor, digite sua senha")
            return false
        }

        if (password.length < 4) {
            showToast("Senha muito curta (mínimo 4 caracteres)")
            return false
        }

        if (password != confirmPassword) {
            showToast("As senhas não coincidem")
            return false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun saveUser(username: String, password: String, email: String, fullName: String) {
        val sharedPreferences = getSharedPreferences("UserCredentials", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username_$username", username)
        editor.putString("password_$username", password)
        editor.putString("email_$username", email)
        editor.putString("fullName_$username", fullName)
        editor.apply()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
