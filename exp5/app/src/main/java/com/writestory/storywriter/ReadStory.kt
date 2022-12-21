package com.writestory.storywriter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ReadStory : AppCompatActivity() {
    override fun onBackPressed() {
        // INTENT FOR YOUR HOME ACTIVITY
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.read_story)

        var text = ""
        var reader: BufferedReader? = null

//        reader = BufferedReader(InputStreamReader(assets.open("story.txt")))
        reader = BufferedReader(InputStreamReader(openFileInput("todolist.txt")))
//        reader = BufferedReader(InputStreamReader(openFileInput("story.txt")))
        try {
//            reader = BufferedReader(InputStreamReader(assets.open("story.txt")))
            text = reader.readLines().joinToString("\n")
        } catch (e: IOException) {
            Toast.makeText(applicationContext, "Error reading license file!", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        } finally {
            try {
                reader?.close()
            } catch (e: IOException) {
                //log the exception
                e.printStackTrace()
            }
            var textView = findViewById<TextView>(R.id.textView)
            textView.text = text
        }

        val buttonClick4 = findViewById<Button>(R.id.button4)
        buttonClick4.setOnClickListener {
            val intent = Intent(this, WriteStory::class.java)
            startActivity(intent)
        }
    }
}