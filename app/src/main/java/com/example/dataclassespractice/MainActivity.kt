package com.example.dataclassespractice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var eA : EditText
    private lateinit var eB : EditText
    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var mul: Button
    private lateinit var divide: Button
    private lateinit var result: TextView
    private lateinit var clear:Button
    private lateinit var calculationAdapter: calcAdapter
    private lateinit var history : HistoryManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        calculationAdapter = calcAdapter(emptyList())
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = calculationAdapter
        history = HistoryManager(calculationAdapter)
        eA = findViewById(R.id.et_a)
        eB = findViewById(R.id.et_b)
        add = findViewById(R.id.btn_add)
        sub = findViewById(R.id.btn_subtract)
        mul = findViewById(R.id.btn_multiply)
        divide = findViewById(R.id.btn_divide)
        result = findViewById(R.id.result_tv)
        clear = findViewById(R.id.clear_history_btn)
        add.setOnClickListener(this)
        sub.setOnClickListener(this)
        mul.setOnClickListener(this)
        divide.setOnClickListener(this)
        clear.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if(eA.text.toString().isNotEmpty() && eB.text.toString().isNotEmpty())
        {
            var x = eA.text.toString().toDouble()
            var y = eB.text.toString().toDouble()
            var resultText = 0.0
            var op:Int = 0
            when(v?.id)
            {
                R.id.btn_add ->{resultText = x+y
                    op = 1
                    history.addCalculation(x,y,op,resultText.toDouble())
                    result.text = "$resultText"}
                R.id.btn_subtract ->{resultText = x-y
                    op = 2
                    history.addCalculation(x,y,op,resultText.toDouble())
                    result.text = "$resultText"}
                R.id.btn_multiply ->{resultText = x*y
                    op = 3
                    history.addCalculation(x,y,op,resultText.toDouble())
                    result.text = "$resultText"}
                R.id.btn_divide ->{resultText = x/y
                    op = 4
                    history.addCalculation(x,y,op,resultText.toDouble())
                    result.text = "$resultText"}
                R.id.clear_history_btn ->{
                    history.clearHistory()
                }
            }
        }

    }
}

