package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splash_screen.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class sign_up : AppCompatActivity() {
    private val binding:ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.signInbutton.setOnClickListener {
            startActivity(Intent(this,login::class.java))
            finish()
        }
binding.registerbutton.setOnClickListener {
    val email=binding.email.text.toString()
    val username=binding.username.toString()
    val password=binding.password.toString()

}
    }
}