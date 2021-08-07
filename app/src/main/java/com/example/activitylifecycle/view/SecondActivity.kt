package com.example.activitylifecycle.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.activitylifecycle.Models.QuestionModel
import com.example.activitylifecycle.R

// A extends B
class SecondActivity : AppCompatActivity() {


    private lateinit var myModel : QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        Log.i("Lifecycle","onCreate")


        val btn : Button = findViewById(R.id.btnAdd)
        val tvQuestion : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

        //method 1
        //if (savedInstanceState != null)
        //tvQuestion.text = savedInstanceState.getString("question") // if = null , then will run time error

        //method 2
        //tvQuestion.text = savedInstanceState?getString("question")

        //myModel = QuestionModel() // rotate screen the question will change

        //myModel = ViewModelProvider(this).get(QuestionModel :: class.java)

        myModel = QuestionModel.getInstance()
        tvQuestion.text = myModel.getQuestion()
        tvName.text = myModel.name

        btn.setOnClickListener(){
            tvQuestion.text = myModel.generateQuestion()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("Lifecycle","onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("Lifecycle","onRestart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("Lifecycle","onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Lifecycle","onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("Lifecycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

            Log.i("Lifecycle","onDestroy")
    }

  /*  override fun onSaveInstanceState(outState: Bundle) {
        // out state is variable to store the data
        super.onSaveInstanceState(outState)

        var question = findViewById<TextView>(R.id.tvQuestion).text.toString()
        outState.putString("question",question)
    }
    */

/*
    fun generateQuestion() : String{
        var no1 = (Math.random()*100).toInt()
        var no2 = (Math.random()*100).toInt()

        return "${no1} + ${no2} = ?"
    }

 */
}