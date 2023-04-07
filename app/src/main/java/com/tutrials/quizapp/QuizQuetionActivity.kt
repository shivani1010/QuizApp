package com.tutrials.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.MessageQueue
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuetionActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar? = null;
    private var tvProgressBar: TextView? = null;

    private var tvQuetion: TextView? = null;
    private var iv_image: ImageView? = null;

    private var tvOption1: TextView? = null;
    private var tvOption2: TextView? = null;
    private var tvOption3: TextView? = null;
    private var tvOption4: TextView? = null;
    private var btnSubmit: Button? = null;

    private var mCurrentPosition: Int=1;
    private var mQuestionList:ArrayList<Question>?=null ;
    private var mSelectedOptionposition: Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_quetion)


        progressBar=findViewById(R.id.progress)
        tvProgressBar=findViewById(R.id.tv_progress)
        tvQuetion=findViewById(R.id.tv_question)
        iv_image=findViewById(R.id.iv_image)
        tvOption1=findViewById(R.id.tv_option1)
        tvOption2=findViewById(R.id.tv_option2)
        tvOption3=findViewById(R.id.tv_option3)
        tvOption4=findViewById(R.id.tv_option4)
        btnSubmit=findViewById(R.id.btn_submit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

       mQuestionList = Constants.getQuestion()

        setQuestion()
        defaultOptionsView()
    }

    private fun defaultOptionsView()
    {
        val options=ArrayList<TextView>()
        tvOption1?.let{
            options.add(0,it)
        }
        tvOption2?.let{
            options.add(0,it)
        }
        tvOption3?.let{
            options.add(0,it)
        }
        tvOption4?.let{
            options.add(0,it)
        }

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_border_box
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int)
    {
        defaultOptionsView()
        mSelectedOptionposition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#7A8089"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    private fun setQuestion() {

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition/ ${progressBar?.max}"
        tvQuetion?.text = question.Question
        iv_image?.setImageResource(question.image)
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size)
        {
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    override fun onClick(view: View?) {
           when(view?.id)
           {
               R.id.tv_option1 -> {
                   tvOption1?.let{
                       selectedOptionView(it,1)
                   }
               }


               R.id.tv_option2 -> {
                   tvOption2?.let{
                       selectedOptionView(it,2)
                   }
               }


               R.id.tv_option3-> {
                   tvOption3?.let{
                       selectedOptionView(it,3)
                   }
               }

               R.id.tv_option4-> {
                   tvOption4?.let{
                       selectedOptionView(it,4)
                   }
               }


               R.id.btn_submit-> {
                    if(mSelectedOptionposition==0)
                    {
                        mCurrentPosition++

                        when{
                            mCurrentPosition <= mQuestionList!!.size ->{
                                setQuestion()
                            }
                        }

                    }else{
                        val question=mQuestionList?.get(mCurrentPosition -1)
                        if(question !!.correctAnswer != mSelectedOptionposition)
                        {
                            answerView(mSelectedOptionposition,R.drawable.red_border_box)
                        }
                        answerView(question.correctAnswer,R.drawable.green_border_box)

                        if(mCurrentPosition == mQuestionList!!.size){
                            btnSubmit?.text="FINISH"
                        }else{
                            btnSubmit?.text="GO TO NEXT QUETION"
                        }

                        mSelectedOptionposition =0
                    }
               }
           }
        }

    private  fun answerView(answer:Int,drawableView: Int){
        when(answer)
        {
                1->{
                    tvOption1?.background=ContextCompat.getDrawable(
                        this,
                        drawableView
                    )
                }

            2->{
                tvOption2?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3->{
                tvOption3?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            4->{
                tvOption4?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }
    }
}