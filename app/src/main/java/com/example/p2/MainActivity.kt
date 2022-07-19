package com.example.p2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var numberText: TextView
    lateinit var editPlayerName: EditText
    lateinit var playerNameTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberText = findViewById(R.id.numberText)
        diceImage = findViewById(R.id.diceImage)
        editPlayerName = findViewById(R.id.editPlayerName)
        playerNameTV = findViewById(R.id.playerName)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDice() }

        val updateButton = findViewById<Button>(R.id.updatePlayerNameBtn)
        updateButton.setOnClickListener{updatePlayerName(it)}
    }

    private fun rollDice() {
        val randomNumb = (1..6).random()
        numberText.text = randomNumb.toString()
        val imgSrc = when (randomNumb) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        diceImage.setImageResource(imgSrc)

        Toast.makeText(
            this,
            randomNumb.toString(),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun updatePlayerName(view: View) {
        playerNameTV.text = editPlayerName.text

        editPlayerName.setText("")
        editPlayerName.clearFocus()

        //hide keyboard after update player name
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}