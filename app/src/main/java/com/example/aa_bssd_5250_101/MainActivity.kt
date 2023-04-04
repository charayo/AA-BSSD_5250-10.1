package com.example.aa_bssd_5250_101

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {

    private lateinit var text:WebView
    private lateinit var codeSource:TextView
    private var source = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT, 0, 0.9F
            )

        }
        val loadCon4 = Button(this).apply {
            text = "Load Connect 4"
            setOnClickListener {
                loadDataTo(webView, "file:///android_asset/connect-4/index.html")
                codeSource.text = "Code taken from: https://github.com/LiteTJ/connect-four"
            }
            layoutParams = LinearLayoutCompat.LayoutParams(
                0,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                .5F
            )
        }

         val loadParticles = Button(this).apply {
            text = "Load Particles"
            setOnClickListener {
                loadDataTo(webView, "file:///android_asset/canvas-fireworks/index.html")
                codeSource.text = "Code taken from: https://github.com/Variadicism-zz/USA-fireworks"
            }
            layoutParams = LinearLayoutCompat.LayoutParams(
                0,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                .5F
            )
        }

        val btnLayout = LinearLayoutCompat(this).apply {
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                0,
                0.1F
            )
            weightSum = 1F
            orientation = LinearLayoutCompat.HORIZONTAL
            addView(loadCon4)
            addView(loadParticles)
        }

        codeSource = TextView(this).apply {
            text = "Code Taken from: "
        }
        val linearLayoutCompat = LinearLayoutCompat(this).apply {
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT
            )
            layoutParams.apply {
                setPadding(10,10,10,10)
            }

            orientation = LinearLayoutCompat.VERTICAL
            addView(btnLayout)
            addView(codeSource)
            addView(webView)
            weightSum = 1.0F
        }
        setContentView(linearLayoutCompat)
    }

    @SuppressLint("JavascriptInterface")
    private fun loadDataTo(webView: WebView, url: String) {
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.loadUrl(url)

    }


    /** Instantiate the interface and set the context  */
    class WebAppInterface(private val mContext: Context) {

        /** Show a toast from the web page  */
        @JavascriptInterface
        fun showToast(toast: String) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
        }
    }
}