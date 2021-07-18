package com.yusufyildiz.quizapp

import android.app.ActivityManager
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.yusufyildiz.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener
{
    private lateinit var binding: ActivityQuizQuestionsBinding
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>?=null
    private var mSelectedOptionPosition : Int = 0


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        mQuestionList = Constants.getQuestions()
        setQuestions()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)

        binding.btnSubmit.setOnClickListener(this)


    }
    fun setQuestions()
    {

        var question = mQuestionList!!.get(mCurrentPosition-1)

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size)
        {
            binding.btnSubmit.text= "FINISH"
        }
        else
        {
            binding.btnSubmit.text = "SUBMIT"
        }

        binding.progressBar.progress = mCurrentPosition
        binding.textViewProgress.text = "$mCurrentPosition"+"/"+"${binding.progressBar.max}"
        binding.questionTextView.text = question!!.question
        binding.imageView.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

    }
    fun defaultOptionsView()
    {
        var options = ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {

        when (v?.id)
        {
            R.id.tv_option_one ->{
                selectedOptionView(binding.tvOptionOne,1)
            }
            R.id.tv_option_two ->
            {
                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(binding.tvOptionThree,3)
            }
            R.id.tv_option_four ->
            {
                selectedOptionView(binding.tvOptionFour,4)
            }
            R.id.btn_submit ->
            {
                if(mSelectedOptionPosition == 0)
                {
                    mCurrentPosition ++

                    when {
                        mCurrentPosition <= mQuestionList!!.size ->
                        {
                            setQuestions()
                        }
                        else ->
                        {
                            Toast.makeText(this,"You have successfully completed the Quiz",Toast.LENGTH_LONG).show()
                        }
                    }

                }
                else
                {
                    var question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_options_border)
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size)
                    {
                        binding.btnSubmit.text = "FINISH"
                    }
                    else
                    {
                        binding.btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }


            }
        }


    }

    fun answerView(answer:Int,drawableView: Int)
    {
        when(answer){
            1 -> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }



    fun selectedOptionView(textView : TextView,selectedOptionNum:Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
    }

}