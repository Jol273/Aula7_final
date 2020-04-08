package com.example.aula7_final

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*


class CalculatorFragment : Fragment() {

    private val TAG = MainActivity::class.java.simpleName
    val operations = mutableListOf(Operation("1+1",2.0),Operation("2+3",5.0))
    var text = SimpleDateFormat("HH:mm:ss").format(Date())
    private val duration = Toast.LENGTH_SHORT
    var lastExpression = ""



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        ButterKnife.bind(this,view)
        return view
    }

    @OnClick(R.id.button_last)
    fun onClickLast(view: View){
        Log.i(TAG,"Click no botão Ultima Conta")
        text_visor.text = lastExpression
    }

    @OnClick(R.id.button_clear)
    fun onClickClear(view: View){
        Log.i(TAG,"Click no botão C")
        text_visor.text = "0"
        /*val toast = Toast.makeText(this, "$text button_clear", duration)
        toast.show()*/
    }

    @OnClick(R.id.button_backspace)
    fun onClickBackSpace(view: View){
        Log.i(TAG,"Click no botão >")
        var str = text_visor.text
        if(str.length > 1) {
            str = str.substring(0,str.length - 1)
            text_visor.text = str
        } else if(str.length <= 1){
            text_visor.text = "0"
        }
        /*val toast = Toast.makeText(this, "$text button_backspace", duration)
        toast.show()*/
    }

    @OnClick(R.id.button_0,R.id.button_1,R.id.button_2,R.id.button_3,R.id.button_4,R.id.button_5,R.id.button_6,R.id.button_7,R.id.button_8,R.id.button_9,R.id.button_dot,R.id.button_adition,R.id.button_subtraction,R.id.button_multiplication,R.id.button_division)
    fun onClickSymbol(view: View){
        val symbol = view.tag.toString()
        if(text_visor.text == "0"){
            text_visor.text = symbol
        } else{
            text_visor.append(symbol)
        }
    }

    @OnClick(R.id.button_equals)
    fun onClickEquals(view : View){
        lastExpression = text_visor.text.toString()
        Log.i(TAG,"Click no botão =")
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        val result = expression.evaluate()
        text_visor.text = result.toString()
        operations.add(Operation(lastExpression, result))
        Log.i(TAG, "O resultado da expressão é ${text_visor.text}")
        /*val toast = Toast.makeText(this, "$text button_equals", duration)
        toast.show()*/
    }

    override fun onDestroy() {
        Log.i(TAG,"o método onDestroy foi invocado")
        super.onDestroy()
    }

    /*@OnClick(R.id.button_history)
    fun onClickHistory(view: View){
        NavigationManager.goToHistoryFragment(supportFragmentManager)
    }*/


}
