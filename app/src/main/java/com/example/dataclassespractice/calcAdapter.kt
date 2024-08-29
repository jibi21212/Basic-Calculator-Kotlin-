package com.example.dataclassespractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class calcAdapter(private var history: List<CalculatorHistory>): RecyclerView.Adapter<calcAdapter.CalculationViewHolder>(){
    class CalculationViewHolder(iV: View): RecyclerView.ViewHolder(iV){
        val tvCalc: TextView = iV.findViewById(R.id.tvCalculation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_calculation, parent, false)
        return CalculationViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalculationViewHolder, position: Int) {
        val calculation = history[position]
        var operation: String = ""
        when(calculation.op)
        {
            1->{operation = "+"}
            2->{operation = "-"}
            3->{operation = "*"}
            4->{operation = "/"}
        }
        holder.tvCalc.text = "${calculation.x.toInt()} $operation ${calculation.y.toInt()} = ${calculation.result}"
    }

    override fun getItemCount(): Int = history.size

    fun updateHistory(newHistory:List<CalculatorHistory>){
        this.history = newHistory
        notifyDataSetChanged()
    }
}
