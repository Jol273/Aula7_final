package com.example.aula7_final

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_expression.view.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORY)

        list_historic.layoutManager = LinearLayoutManager(this)
        list_historic.adapter = HistoryAdapter(this, R.layout.item_expression,operations)

    }
}

class HistoryAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Operation>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>(){

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val expresssion: TextView = view.text_expression
        val result: TextView = view.text_result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(context).inflate(layout,parent,false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.expresssion.text = items[position].expresssion
        holder.result.text = items[position].result.toString()
    }

    override fun getItemCount() = items.size
}

@Parcelize
class Operation(val expresssion : String, val result: Double) : Parcelable