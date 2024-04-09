package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splash_screen.databinding.ActivityJunctionBinding
import com.example.splash_screen.databinding.ActivityLoginBinding



    class junction : AppCompatActivity() {
        private val binding: ActivityJunctionBinding by lazy {
            ActivityJunctionBinding.inflate(layoutInflater)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(binding.root)

            binding.studentButton.setOnClickListener {
                startActivity(Intent(this,skills_homepage::class.java))
                finish()
            }

            binding.teacherButton.setOnClickListener {
                startActivity(Intent(this,splash_screen::class.java))
                finish()
            }

        }


    }
}