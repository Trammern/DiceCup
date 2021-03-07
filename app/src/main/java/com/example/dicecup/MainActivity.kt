package com.example.dicecup

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.dicecupcompulsory.R
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {
    private val diceId = intArrayOf(0, R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )



    val listHistory = mutableListOf<Int>()
    private val mRandomGenerator = Random()
    private lateinit var btnHistory: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main)
        BtnRoll.setOnClickListener { v -> onClickRoll() }
        btnHistory = findViewById(R.id.BtnHistory)
        populateSpinner()
        btnHistory.setOnClickListener {
            val intent = Intent(this, History::class.java)
            intent.putExtra("history", listHistory as Serializable)
            startActivity(intent)

        }
    }

    private fun onClickRoll() {

        if (SpDices.selectedItemPosition == 0)
        {
        val e1 = mRandomGenerator.nextInt(6) + 1
            listHistory.add(e1)

        }
        if (SpDices.selectedItemPosition == 1)
        {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            listHistory.add(e1)
            listHistory.add(e2)
        }
        if (SpDices.selectedItemPosition == 2)
        {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            listHistory.add(e1)
            listHistory.add(e2)
            listHistory.add(e3)
        }
        if (SpDices.selectedItemPosition == 3)
        {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            val e4 = mRandomGenerator.nextInt(6) + 1
            listHistory.add(e1)
            listHistory.add(e2)
            listHistory.add(e3)
            listHistory.add(e4)
        }
        if (SpDices.selectedItemPosition == 4)
        {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            val e4 = mRandomGenerator.nextInt(6) + 1
            val e5 = mRandomGenerator.nextInt(6) + 1
            listHistory.add(e1)
            listHistory.add(e2)
            listHistory.add(e3)
            listHistory.add(e4)
            listHistory.add(e5)
        }
        if (SpDices.selectedItemPosition == 5)
        {
            val e1 = mRandomGenerator.nextInt(6) + 1
            val e2 = mRandomGenerator.nextInt(6) + 1
            val e3 = mRandomGenerator.nextInt(6) + 1
            val e4 = mRandomGenerator.nextInt(6) + 1
            val e5 = mRandomGenerator.nextInt(6) + 1
            val e6 = mRandomGenerator.nextInt(6) + 1
            listHistory.add(e1)
            listHistory.add(e2)
            listHistory.add(e3)
            listHistory.add(e4)
            listHistory.add(e5)
            listHistory.add(e6)
        }
        updateDicesWith(listHistory)
    }
    private fun updateDicesWith(list: List<Int>) {
        if (list.size == 1) {
            imgDice1.setImageResource(diceId[list.first()])
        }
        if (list.size == 2) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
        }
        if (list.size == 3) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
        }
        if (list.size == 4) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
            imgDice4.setImageResource(diceId[list.get(3)])
        }
        if (list.size == 5) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
            imgDice4.setImageResource(diceId[list.get(3)])
            imgDice5.setImageResource(diceId[list.get(4)])
        }
        if (list.size == 6) {
            imgDice1.setImageResource(diceId[list.first()])
            imgDice2.setImageResource(diceId[list.get(1)])
            imgDice3.setImageResource(diceId[list.get(2)])
            imgDice4.setImageResource(diceId[list.get(3)])
            imgDice5.setImageResource(diceId[list.get(4)])
            imgDice6.setImageResource(diceId[list.get(5)])
        }

    }
    private fun populateSpinner(){
        ArrayAdapter.createFromResource(
            this,
            R.array.dices,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            SpDices.adapter = adapter

            SpDices.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                            when (position) {
                                0 -> {
                                imgDice2.isVisible = false
                                    imgDice3.isVisible = false
                                    imgDice4.isVisible = false
                                    imgDice5.isVisible = false
                                    imgDice6.isVisible = false
                                }
                                1 -> {
                                    imgDice2.isVisible = true
                                    imgDice3.isVisible = false
                                    imgDice4.isVisible = false
                                    imgDice5.isVisible = false
                                    imgDice6.isVisible = false
                                }
                                2 -> {
                                    imgDice2.isVisible = true
                                    imgDice3.isVisible = true
                                    imgDice4.isVisible = false
                                    imgDice5.isVisible = false
                                    imgDice6.isVisible = false
                                }
                                3 -> {
                                    imgDice2.isVisible = true
                                    imgDice3.isVisible = true
                                    imgDice4.isVisible = true
                                    imgDice5.isVisible = false
                                    imgDice6.isVisible = false
                                }
                                4 -> {
                                    imgDice2.isVisible = true
                                    imgDice3.isVisible = true
                                    imgDice4.isVisible = true
                                    imgDice5.isVisible = true
                                    imgDice6.isVisible = false
                                }
                                5 -> {
                                    imgDice2.isVisible = true
                                    imgDice3.isVisible = true
                                    imgDice4.isVisible = true
                                    imgDice5.isVisible = true
                                    imgDice6.isVisible = true
                                }
                            }

                }
            }
        }}
}