package com.example.aula7_final

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : Fragment() {

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_history)
        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORY)

        //list_historic.layoutManager = LinearLayoutManager(activity as Context)
        //list_historic.adapter = HistoryAdapter(activity as Context,R.layout.item_expression,operations)

    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORY)

        list_historic.layoutManager = LinearLayoutManager(activity as Context)
        //list_historic.adapter = HistoryAdapter(this,R.layout.item_expression,operations)

        return inflater.inflate(R.layout.activity_history,container,false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }
}

