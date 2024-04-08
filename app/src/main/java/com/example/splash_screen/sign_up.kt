package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

        firebaseAuth= FirebaseAuth.getInstance()
        binding.signInbutton.setOnClickListener {
            startActivity(Intent(this,login::class.java))
            finish()
        }
binding.registerbutton.setOnClickListener {
    //get text from sign up page
    val email=binding.email.text.toString()
    val username=binding.username.text.toString()
    val password=binding.password.text.toString()

    if(email.isEmpty() || username.isEmpty() || password.isEmpty() ){
        Toast.makeText(this, "PLEASE FILL ALL THE DETAILS", Toast.LENGTH_SHORT).show()
    }
    else{
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener (this){task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "REGISTRATION SUCCESSFUL", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,login::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this, "REGISTRATION FAILED  ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
    }
}