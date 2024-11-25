package com.calender

import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a RelativeLayout as the root layout
        val layout = RelativeLayout(this)
        layout.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        // Initialize WebView
        val webView = WebView(this)
        webView.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        // Configure WebView settings
        webView.webViewClient = WebViewClient() // Keeps navigation in the app
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Add Debugging
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.d("WebView", consoleMessage.message())
                return true
            }
        }

        // Add WebView to the layout and load URL
        layout.addView(webView)
        setContentView(layout)
        webView.loadUrl("https://calender-snowy.vercel.app/") // Replace with your URL
    }
}