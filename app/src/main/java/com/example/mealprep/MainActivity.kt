package com.example.mealprep
//CODE is from gennotify app and calculator app
//https://www.youtube.com/watch?v=lwTjXJVheK0&pp=ygUSa2luY2FkZSBnYXJhbmdhbmdh
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var timeInt: EditText? = null
    private var resultTxt: TextView? = null
    //Used private var for Declaring and so people don't change//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // this is used to link id from activity main to kotlin file
        timeInt = findViewById(R.id.timeInt)
        // this is used to link id from activity main to kotlin file
        resultTxt = findViewById(R.id.resultTxt)
        //the val btnSuggestMeal is declaring the button
        val btnSuggestMealType = findViewById<Button>(R.id.SuggestMeal)
        // the val btnclear is used to declare the button to clear the input
        val btnClear = findViewById<Button>(R.id.btnClear)
        // the val btnexit is used to declare the button to exit the app
        val btnExit = findViewById<Button>(R.id.btnExit)
        // btnsuggestmealtype.setonclicklisterner is used for declaring the button
        btnSuggestMealType.setOnClickListener {
            checksuggestion()
        }
        // btnclear.setonclicklistener is used to clear the time Inputed by user and clear the result
        btnClear.setOnClickListener {
            timeInt?.text?.clear()
            resultTxt?.text = ""
        }
        // btnExit is used to exit the app
        btnExit.setOnClickListener {
            finishActivity(1)
            exitProcess(0)
        }
    }

    private fun isNotEmpty(): Boolean {
        var b = true
        val timeText = resultTxt?.text.toString().trim()

        if (timeText.isEmpty()) {
            resultTxt?.error = "Input required!"

            b = false

        } else {
            val time = timeText.toIntOrNull()
            if (time == null) {
                resultTxt?.error = "Invalid input. Please enter a valid number."
                b = false
            }
        }
        return b
    }
    // this private fun isEmpty is used to prevent the app from crashing when the user inputs incorrect time,allows them to understand and input a correct answer
    private fun isEmpty(): Boolean{
        var b = true
        if( timeInt?.text.toString().trim().isEmpty()){
            timeInt?.error ="Input required"
            b = false
        }

        return b

    }

    // this private fun checksuggestion is used to suggest a meal between each range given the time the user inputs
    private fun checksuggestion() {

        if (isEmpty()) {

            when (timeInt?.text.toString().trim().toInt()) {
                in 100..500 -> resultTxt?.text="should be resting or you can just get a glass of water "
                in 501..700 -> resultTxt?.text = "Cereal or Greek yougurt with fruits and sprinkeled seeds or Breakfast bourrito"
                in 701..1100 -> resultTxt?.text = "Sunny side up eggs with mushrooms or Baked sweet Potato topped with avacado and salsa"
                in 1101..1200 ->resultTxt?.text = "Pancakes with blueberry sauces or flapjacks with syrupor French toast with jam"
                in 1201..1500 -> resultTxt?.text = "chicken noodle soup or cheese and crackers or ham and cheese sandwich"
                in 1501..1800 -> resultTxt?.text = "Smopthie with fruits,yogurt or Fruits"
                in 1801..2100 -> resultTxt?.text = "grilled chicken or fish with roasted vegetables or stir-fried rice with chicken"
                in 2101..2359 -> resultTxt?.text = "Blueberry cheesecake or malva pudding with custard or waffles with ice cream"

                else -> {
                    resultTxt?.text = "Incorrect time input(PLease include a valid time,thank you)"
                }}}}}




