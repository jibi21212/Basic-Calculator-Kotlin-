package com.example.dataclassespractice

import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class HistoryManager(private val adapter: calcAdapter) {
    private val history = mutableListOf<CalculatorHistory>()

    fun addCalculation(x:Double,y:Double,op:Int,result:Double)
    {
        val calculation = CalculatorHistory(x,y,op,result)
        history.add(calculation)
        adapter.updateHistory(history)
    }
    fun clearHistory()
    {
        history.clear()
        adapter.updateHistory(history)
    }
}