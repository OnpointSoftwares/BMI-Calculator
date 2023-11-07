package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email:EditText=findViewById(R.id.txtEmail)
        val password:EditText=findViewById(R.id.txtPassword)
        val auth:FirebaseAuth=FirebaseAuth.getInstance()
        val btnLogin:MaterialButton=findViewById(R.id.btnLogin)
        val btnReg:MaterialButton=findViewById(R.id.btnReg)
        btnReg.setOnClickListener {
            startActivity(Intent(this,Signup::class.java))
        }
        btnLogin.setOnClickListener {
            if(email.text.toString().equals("")||password.text.toString().equals(""))
            {
                val alertd=AlertDialog.Builder(this)
                alertd.setMessage("Please fill all the details to continue")
                alertd.setTitle("Empty Username or Password")
                alertd.setPositiveButton("Ok"){dialog,_->
                    dialog.dismiss()
                }
                alertd.setNegativeButton("Cancel"){dialog,_->
                    dialog.dismiss()
                }
                alertd.create().show()
            }
            else {
                login(email.text.toString(), password.text.toString())
            }
        }

    }

    private fun login(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful)
            {
                startActivity(Intent(this,BMICalc::class.java))
                Toast.makeText(this@MainActivity,"Login successful",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this@MainActivity,"Wrong password or email",Toast.LENGTH_LONG).show()
            }
        }
    }
}