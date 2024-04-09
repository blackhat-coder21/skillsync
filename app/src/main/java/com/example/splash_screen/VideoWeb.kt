package com.example.splash_screen

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoWeb : AppCompatActivity() {

    lateinit var webview: WebView
    lateinit var video: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_web)

        webview = findViewById(R.id.webView)
        video = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/e9cefe-xD04?si=pT-y5OTF3fDnYP2I\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
        webview.loadData(video, "text/html", "utf-8")
        webview.webChromeClient = WebChromeClient()
    }
}