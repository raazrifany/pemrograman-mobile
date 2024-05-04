package simi.unikom.userinterface2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var fullNameButton: Button
    private lateinit var fullNameTextView: TextView
    private lateinit var resourceButton: Button
    private fun initComponents() {
        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        fullNameButton = findViewById(R.id.fullNameButton)
        fullNameTextView = findViewById(R.id.fullNameTextView)
        resourceButton = findViewById(R.id.resourceButton)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v,
                                                                             insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top,
                systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        fullNameButton.setOnClickListener {
            Log.d("PPM", "debug log")
            Log.i("PPM", "info log")
            Log.w("PPM", "warning log")
            Log.e("PPM", "error log")
            val fullname = firstNameEditText.text.toString() + " " +
                    lastNameEditText.text.toString()
            fullNameTextView.text =
                resources.getString(R.string.get_full_name, fullname)
        }

        resourceButton.setOnClickListener {
            val intent = Intent(this, ResourceActivity::class.java)
            startActivity(intent)
        }
    }
}
