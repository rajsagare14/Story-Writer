package com.writestory.storywriter
//
//
//import android.R
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*

class WriteStory : AppCompatActivity() {
    //    private var todoText: EditText? = null
//    private var saveButton: Button? = null
        override fun onBackPressed() {
        // INTENT FOR YOUR HOME ACTIVITY
        val intent = Intent(this, ReadStory::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.write_story)
        var todoText = findViewById<EditText>(R.id.todoText)
        var saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener(View.OnClickListener {
            if (todoText.text.toString() != "") {
                val message = todoText.text.toString()
                writeToFile(message)
                Toast.makeText(this@WriteStory, "Saved!", Toast.LENGTH_LONG).show()
            }
        })
        try {
            if (readFromFile() != null) {
                todoText.setText(readFromFile())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun writeToFile(message: String) {
        try {
            val outputStreamWriter = OutputStreamWriter(
                openFileOutput(
                    "todolist.txt",
                    MODE_PRIVATE
                )
            )
            outputStreamWriter.write(message)
            outputStreamWriter.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    private fun readFromFile(): String? {
        var result = ""
        val inputStream: InputStream? = openFileInput("todolist.txt")
        if (inputStream != null) {
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            var temp: String? = ""
            val stringBuilder = StringBuilder()
            while (bufferedReader.readLine().also { temp = it } != null) {
                stringBuilder.append(temp)
                stringBuilder.append("\n")
            }
            inputStream.close()
            result = stringBuilder.toString()
        }

        return result
    }
}