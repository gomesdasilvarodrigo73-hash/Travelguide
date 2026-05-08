package com.example.travelguide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: TextInputEditText = findViewById(R.id.usernameEditText)
        val passwordEditText: TextInputEditText = findViewById(R.id.passwordEditText)
        val loginButton: MaterialButton = findViewById(R.id.loginButton)
        val registerButton: MaterialButton = findViewById(R.id.registerButton)
        val forgotPasswordTextView: android.widget.TextView = findViewById(R.id.forgotPasswordTextView)

        // Configurar listeners dos botões com animações e feedback
        setupButtonAnimations(loginButton, registerButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateLogin(username, password)) {
                // Salvar sessão
                saveUserSession(username)
                
                // Navegar para MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }

        registerButton.setOnClickListener {
            // Navegar para tela de registro
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        forgotPasswordTextView.setOnClickListener {
            // Mostrar mensagem de recuperação de senha
            showRecoveryDialog()
        }
    }

    private fun setupButtonAnimations(vararg buttons: MaterialButton) {
        buttons.forEach { button ->
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
    }

    private fun validateLogin(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            showToast("Por favor, digite seu nome de usuário")
            return false
        }

        if (password.isEmpty()) {
            showToast("Por favor, digite sua senha")
            return false
        }

        if (username.length < 3) {
            showToast("Nome de usuário muito curto")
            return false
        }

        if (password.length < 4) {
            showToast("Senha muito curta")
            return false
        }

        // Validar credenciais (simulação)
        if (username == "admin" && password == "1234") {
            showToast("Login realizado com sucesso!")
            return true
        } else {
            showToast("Usuário ou senha incorretos")
            return false
        }
    }

    private fun saveUserSession(username: String) {
        val sharedPreferences = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putBoolean("isLoggedIn", true)
        editor.apply()
    }

    private fun showRecoveryDialog() {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Recuperar Senha")
            .setMessage("Digite seu email para receber instruções de recuperação:")
            .setView(android.widget.EditText(this).apply {
                hint = "seu@email.com"
                inputType = android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            })
            .setPositiveButton("Enviar") { dialog, _ ->
                showToast("Email de recuperação enviado!")
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        
        // Verificar se já está logado
        val sharedPreferences = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        
        if (isLoggedIn) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
