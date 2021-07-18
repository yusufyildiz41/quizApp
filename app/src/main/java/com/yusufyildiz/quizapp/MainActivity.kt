package com.yusufyildiz.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yusufyildiz.quizapp.databinding.ActivityMainBinding
import com.yusufyildiz.quizapp.databinding.ActivityMainBinding.bind
import com.yusufyildiz.quizapp.databinding.ActivityMainBinding.inflate
import com.yusufyildiz.quizapp.databinding.ActivityQuizQuestionsBinding.inflate

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN  //full screen

        binding.startButton.setOnClickListener {

            if(binding.nameEditText.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please enter a name !!!",Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

    }
}