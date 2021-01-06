package com.example.instragram

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.instragram.model.User

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnsignup: Button
    private lateinit var btnlogin: Button

    var username: String = String()
    var password: String = String()
    var fullname: String = String()
    var batchname: String = String()

    val userList = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etpassword = findViewById(R.id.etpassword)
        etusername = findViewById(R.id.etusername)
        btnlogin = findViewById(R.id.btnlogin)
        btnsignup = findViewById(R.id.btnsignup)
        btnsignup.setOnClickListener(this)
        btnlogin.setOnClickListener(this)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val args = data?.getParcelableExtra<User>("userdata") as User
                userList.add(args)
                username = userList[0].username.toString()
                password = userList[0].password.toString()
                fullname =
                    userList[0].fname.toString() + " " + userList[0].lname.toString();
                batchname = userList[0].batchName.toString()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnsignup -> {
                startActivityForResult(Intent(this, RegisterUser::class.java), 1);
            }
            R.id.btnlogin -> {
                if (TextUtils.isEmpty(etusername.text.toString())) {
                    etusername.error = "Enter Username";
                    etusername.requestFocus();
                } else if (TextUtils.isEmpty(etpassword.text.toString())) {
                    etpassword.error = "Enter Password";
                    etpassword.requestFocus();
                } else {
                    if (userList.size <= 0) {
                        Toast.makeText(
                            this,
                            "No Users Added To Collection. Please Add Users First !",
                            Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        if (etusername.text.toString() == username && etpassword.text.toString() == password) {
                            val intent: Intent = Intent(this, User_Dashboard::class.java);
                            intent.putExtra("fullname", fullname);
//                            intent.putExtra("batch", batch);
                            startActivity(intent);
//                            Toast.makeText(this, "Welcome $fullname", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(
                                this,
                                "Either Usernam or Password Doesnot Match",
                                Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
            }
        }
    }
}