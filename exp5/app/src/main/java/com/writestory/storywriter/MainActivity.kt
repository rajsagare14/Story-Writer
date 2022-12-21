package com.writestory.storywriter
//
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//
//import android.R
//import android.os.Bundle
import android.view.View
//import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
import java.io.*
class MainActivity : AppCompatActivity() {
//    private var todoText: EditText? = null
//    private var saveButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
        val buttonClick = findViewById<Button>(R.id.button)
        buttonClick.setOnClickListener {
            val intent = Intent(this, ReadStory::class.java)
            startActivity(intent)
        }

        val buttonClick2 = findViewById<Button>(R.id.button2)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, WriteStory::class.java)
            startActivity(intent)

        }
        val buttonClick3 = findViewById<Button>(R.id.button3)
        buttonClick3.setOnClickListener {
            finish()
            System.exit(1)
        }
    }
}
//package com.example.muskanhussain.honeydolist



//class MainActivity : AppCompatActivity() {
//    private var todoText: EditText? = null
//    private var saveButton: Button? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        var todoText = findViewById<EditText>(R.id.todoText)
//        var saveButton = findViewById<Button>(R.id.saveButton)
//        saveButton.setOnClickListener(View.OnClickListener {
//            if (todoText.text.toString() != "") {
//                val message = todoText.text.toString()
//                writeToFile(message)
//                Toast.makeText(this@MainActivity, "Saved!", Toast.LENGTH_LONG).show()
//            }
//        })
//        try {
//            if (readFromFile() != null) {
//                todoText.setText(readFromFile())
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//
//    private fun writeToFile(message: String) {
//        try {
//            val outputStreamWriter = OutputStreamWriter(
//                openFileOutput(
//                    "todolist.txt",
//                    MODE_PRIVATE
//                )
//            )
//            outputStreamWriter.write(message)
//            outputStreamWriter.close()
//        } catch (e: FileNotFoundException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//
//    @Throws(IOException::class)
//    private fun readFromFile(): String? {
//        var result = ""
//        val inputStream: InputStream? = openFileInput("todolist.txt")
//        if (inputStream != null) {
//            val inputStreamReader = InputStreamReader(inputStream)
//            val bufferedReader = BufferedReader(inputStreamReader)
//            var temp: String? = ""
//            val stringBuilder = StringBuilder()
//            while (bufferedReader.readLine().also { temp = it } != null) {
//                stringBuilder.append(temp)
//                stringBuilder.append("\n")
//            }
//            inputStream.close()
//            result = stringBuilder.toString()
//        }
//        return result
//    }
//}