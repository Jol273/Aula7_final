package com.example.aula7_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORY)

        list_historic.layoutManager = LinearLayoutManager(this)
        list_historic.adapter = HistoryAdapter(this,R.layout.item_expression,operations)

    }
}

