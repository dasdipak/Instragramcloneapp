package com.example.instragram

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class story_activity : AppCompatActivity() {

    private lateinit var btnSubmit: Button;
    private lateinit var etURL: EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_activity)

        btnSubmit = findViewById(R.id.btnSubmit);
        etURL = findViewById(R.id.etURL);

        btnSubmit.setOnClickListener {
            val url = etURL.text.toString();

            val intent = Intent(this, User_Dashboard::class.java);
            intent.putExtra("url", url);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    }
}