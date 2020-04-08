package com.example.aula7_final

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    val operations = mutableListOf(Operation("1+1",2.0),Operation("2+3",5.0))

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORY)



    }*/

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_history, container, false)

            list_history.adapter = HistoryAdapter(activity as Context, R.layout.item_expression, operations)
            list_history.layoutManager = LinearLayoutManager(activity as Context)

            return view
        }


}

