package com.example.instragram

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class post_activity : AppCompatActivity() {

    private lateinit var etURL: EditText;
    private lateinit var btnSubmit: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_activity)

        etURL = findViewById(R.id.etURL);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener {
            val url = etURL.text.toString();

            val intent = Intent(this, User_Dashboard::class.java);
            intent.putExtra("url", url);
            setResult(Activity.RESULT_OK, intent);
            finish();
//            Toast.makeText(this,"$url", Toast.LENGTH_SHORT).show();
        }
    }
}