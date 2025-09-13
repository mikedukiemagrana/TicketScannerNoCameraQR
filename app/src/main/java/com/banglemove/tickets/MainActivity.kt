package com.banglemove.tickets

import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Keep screen on while scanning with the Bluetooth scanner
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        webView = findViewById(R.id.webview)
        loadWebView()
    }

    private fun loadWebView() {
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.allowFileAccess = true
        settings.databaseEnabled = true
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.mediaPlaybackRequiresUserGesture = true

        webView.webViewClient = object : WebViewClient() {}
        webView.webChromeClient = WebChromeClient()

        // Load your local web app (no camera needed; Bluetooth scanner acts like a keyboard)
        webView.loadUrl("file:///android_asset/index.html")

        // Ensure WebView can capture keyboard input from HID scanners
        webView.isFocusable = true
        webView.isFocusableInTouchMode = true
        webView.requestFocus()
    }

    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}