package com.accidentaldeveloper.heart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val textView = findViewById<TextView>(R.id.textView)
        val ThinkBot = "Athrav"
        val stringBuilder1 = StringBuilder()
        val t1 = Thread {
            for (letters in ThinkBot) {
                stringBuilder1.append(letters)
                Thread.sleep(280)
                runOnUiThread {
                    textView.text = stringBuilder1.toString()
                }
            }
            val jump: Intent = Intent(this@Splash_Screen, Login_Sing_Up_Screen::class.java)
            startActivity(jump)
            finish()
        }.start()
    }
}