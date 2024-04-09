package com.example.splash_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class mentor_content_details : AppCompatActivity() {


    lateinit var gotoPIP:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentor_content_details)

//        val url = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/e9cefe-xD04?si=QEj6W5_9szGV9ThX\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        gotoPIP=findViewById(R.id.gotodemo)

        gotoPIP.setOnClickListener {
            val intent= Intent(this@mentor_content_details,VideoWeb::class.java)
//            intent.putExtra("url",url)
            startActivity(intent)
        }
    }
}