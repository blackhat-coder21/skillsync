package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splash_screen.databinding.ActivityLoginBinding
import com.example.splash_screen.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.time.Instant

class login : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var firebaseAuth: FirebaseAuth
//    override fun onStart() {
//        super.onStart()
//        val currentUser : FirebaseUser ? = firebaseAuth.currentUser
//
//        if(currentUser !=null){
//            startActivity(Inten
    //            t(this,MainActivity::class.java))
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()


        binding.logInbutton.setOnClickListener {
            //get text from sign up page

            val username=binding.useremail.text.toString()
            val password=binding.password.text.toString()
            if( username.isEmpty() || password.isEmpty() ){
                Toast.makeText(this, "PLEASE FILL ALL THE DETAILS", Toast.LENGTH_SHORT).show()
            }
            else{
                firebaseAuth.signInWithEmailAndPassword(username,password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful) {
                            Toast.makeText(this, "SIGN-IN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "SIGN-IN FAILED  ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }

                        }


                    }
            }
            binding.signUpbutton.setOnClickListener {
            startActivity(Intent(this,sign_up::class.java))
            finish()
        }


    }
}