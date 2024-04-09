package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splash_screen.databinding.ActivityAddTeacherProfileBinding
import com.example.splash_screen.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class add_teacher_profile : AppCompatActivity() {
     val binding: ActivityAddTeacherProfileBinding by lazy {
        ActivityAddTeacherProfileBinding.inflate(layoutInflater)
    }
   // private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        databaseReference = FirebaseDatabase.getInstance().getReference("users")


        binding.addButton.setOnClickListener {
            //get text from sign up page

            val name = binding.logeName.text.toString()
            val email = binding.logeEmail.text.toString()
            val specialization = binding.Specialization.text.toString()
            val experience = binding.Experience.text.toString()
            val fees = binding.Fees.text.toString()
            val description = binding.Description.text.toString()


            if (name.isEmpty() || email.isEmpty() || specialization.isEmpty() || experience.isEmpty() || fees.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "PLEASE FILL ALL THE DETAILS", Toast.LENGTH_SHORT).show()
            }

            databaseReference = FirebaseDatabase.getInstance().getReference("Teachers")

            val Teacher = Teacher(name, email, specialization, experience, fees, description)

            databaseReference.child(name).setValue(Teacher).addOnCanceledListener {
                binding.logeName.text.clear()
                binding.logeEmail.text.clear()
                binding.Specialization.text.clear()
                binding.Experience.text.clear()
                binding.Fees.text.clear()
                binding.Description.text.clear()



                Toast.makeText(this, "ADDED DATA SUCCESSFULLY", Toast.LENGTH_SHORT).show()
                //startActivity(Intent(this,skills_homepage::class.java))
            }.addOnFailureListener {
                Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show()
            }


        }
    }
}