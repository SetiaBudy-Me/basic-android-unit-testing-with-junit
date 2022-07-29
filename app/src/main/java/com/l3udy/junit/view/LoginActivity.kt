package com.l3udy.junit.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.l3udy.junit.databinding.ActivityLoginBinding
import com.l3udy.junit.viewmodel.LoginViewModel

/*
 *  LoginActivity:
 *  - Shows the UI
 *  - Listens to viewModel for updates on UI
 */
class LoginActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityLoginBinding

    // Create a viewModel
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set viewModel
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        setupClickListeners()
        setupObserver()
    }

    // Setup the button in our activity
    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.login(email, password)
        }
    }

    // Observer is waiting for viewModel to update our UI
    private fun setupObserver() {
        viewModel.loginResult.observe(this@LoginActivity) {
            when {
                it.success != null -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                it.error != null -> Toast.makeText(this, getString(it.error), Toast.LENGTH_SHORT).show()
                it.errorMessage != null -> Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}