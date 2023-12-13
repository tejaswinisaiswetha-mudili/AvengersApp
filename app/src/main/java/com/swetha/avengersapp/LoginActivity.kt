package com.swetha.avengersapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etmobileno:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:Button
    lateinit var txtForPassword:TextView
    lateinit var textRegister:TextView
    val validMobileNumber="0123456789"
    val validPassword= arrayOf("tony","steve","bruce","thanos")

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn){
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title="AVENGERS"
        etmobileno=findViewById(R.id.etmobileno)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForPassword=findViewById(R.id.txtForPassword)
        textRegister=findViewById(R.id.textRegister)
        btnLogin.setOnClickListener {
            val mobileNumber=etmobileno.text.toString()
            val password=etPassword.text.toString()
            var nameOfAvenger="Avengers"
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            if((mobileNumber==validMobileNumber)){
                if (password==validPassword[0]){
                    nameOfAvenger="Iron Man"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else if (password==validPassword[1]){
                    nameOfAvenger="Captain America"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[2]){
                    nameOfAvenger="The Hulk"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[3]){
                    nameOfAvenger="The Avengers"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
            }

            else{
            Toast.makeText(this@LoginActivity,"Incorrect Credentials!",Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }


}