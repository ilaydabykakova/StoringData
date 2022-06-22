package com.ilaydabykakova.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ilaydabykakova.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Shared Preferences Intialize

        sharedPreferences = this.getSharedPreferences("com.ilaydabykakova.storingdata",
            MODE_PRIVATE)
        //default value : if there is a value null , return zero.
        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if (ageFromPreferences ==-1){
            binding.resultText.text = "Your Age : "
        }else{
            binding.resultText.text="Your Age : $ageFromPreferences"
        }


    }

    fun save(view: View){
        // Shared Preferences
       val myAge = binding.editText.text.toString().toIntOrNull()

        if(myAge == null){
            binding.resultText.text = "There is no age to save it !"
        }else {
            binding.resultText.text = "Your Age : ${myAge}"
            sharedPreferences.edit().putInt("age",myAge).apply()
        }


    }
    fun delete(view: View){
        ageFromPreferences = sharedPreferences.getInt("age",-1)
        if (ageFromPreferences !=-1){
            sharedPreferences.edit().remove("age").apply()
            binding.resultText.text = "Your Age: "
        }

    }
}