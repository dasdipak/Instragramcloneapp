package com.example.instragram

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.example.instragram.model.User

class RegisterUser : AppCompatActivity(), View.OnClickListener {

    private lateinit var etfname: EditText
    private lateinit var etlname: EditText
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var etrepassword: EditText
    private lateinit var spinnerbatchname: Spinner
    //    private lateinit var profileimage: ImageView
    private lateinit var btnsignup: Button


    var i: Int = 1;
    private val arrStudent = arrayListOf<String>(
        "24A", "24B", "25A", "25B", "25C", "25D"
    );
    var batchname: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        etfname = findViewById(R.id.etfname);
        etlname = findViewById(R.id.etlname);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        etrepassword = findViewById(R.id.etrepassword);
        spinnerbatchname = findViewById(R.id.spinnerbatchname);
//        profileimage = findViewById(R.id.profileimage);
        btnsignup = findViewById(R.id.btnsignup)


        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrStudent);
        spinnerbatchname.adapter = adapter;
        spinnerbatchname.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                batchname = parent?.getItemAtPosition(position).toString();
            }
        }
        btnsignup.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnsignup -> {
                var id = i++;
                if (TextUtils.isEmpty(etfname.text.toString())) {
                    etfname.error = "Please Enter Firstname";
                    etfname.requestFocus();
                } else if (TextUtils.isEmpty(etlname.text.toString())) {
                    etlname.error = "Please Enter Lastname";
                    etlname.requestFocus();
                } else if (TextUtils.isEmpty(etusername.text.toString())) {
                    etusername.error = "Please Enter Username";
                    etusername.requestFocus();
                } else if (TextUtils.isEmpty(etpassword.text.toString())) {
                    etpassword.error = "Please Enter Password";
                    etpassword.requestFocus();
                } else if (TextUtils.isEmpty(etrepassword.text.toString())) {
                    etrepassword.error = "Re-enter password";
                    etrepassword.requestFocus();
                } else {
                    var fname = etfname.text.toString();
                    var lname = etlname.text.toString();
                    var username = etusername.text.toString();
                    var password = etpassword.text.toString();
                    var repassword = etrepassword.text.toString();
                    if (password != repassword) {
                        etrepassword.error = "Password not match";
                        etrepassword.requestFocus();
                    }
                    val user = User(id, fname, lname, username, password, batchname);
                    val intent: Intent = intent
                    intent.putExtra("userdata", user);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        }
    }
    fun resetText() {
        etfname.setText("")
        etlname.setText("")
        etusername.setText("")
        etpassword.setText("")
        etrepassword.setText("")

    }
}