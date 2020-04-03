package com.example.aula7_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import butterknife.OnClick
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_calculator.*

const val EXTRA_HISTORY = "com.example.aula7_final"

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private val VISOR_KEY = "visor"

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"o metodo onCreate foi invocado")
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupDrawerMenu()
        NavigationManager.goToCalculatorFragment(supportFragmentManager)

    /*val orientation = getResources().getConfiguration().orientation
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        list_historic.adapter = HistoryAdapter(this, R.layout.item_expression, operations)
    }


    button_division.setOnClickListener{
        Log.i(TAG, "Click no botão /")
        onClickSymbol("/")
        val toast = Toast.makeText(this, "$text button_division", duration)
        toast.show()
        //text_visor.append("!")
    }

    button_multiplication.setOnClickListener {
        Log.i(TAG,"Click no botão *")
        onClickSymbol("*")
        val toast = Toast.makeText(this, "$text button_multiplication", duration)
        toast.show()
        //text_visor.append("?")
    }

    button_subtraction.setOnClickListener {
        Log.i(TAG,"Click no botão -")
        onClickSymbol("-")
        val toast = Toast.makeText(this, "$text button_#", duration)
        toast.show()
        //text_visor.append("#")
    }

    button_adition.setOnClickListener{
        Log.i(TAG, "Click no botão +")
        onClickSymbol("+")
        val toast = Toast.makeText(this, "$text button_adition", duration)
        toast.show()
    }

    button_9.setOnClickListener{
        Log.i(TAG,"Click no botão 7")
        onClickSymbol("9")
        val toast = Toast.makeText(this, "$text button_6", duration)
        toast.show()
    }

    button_8.setOnClickListener{
        Log.i(TAG,"Click no botão 5")
        onClickSymbol("8")
        val toast = Toast.makeText(this, "$text button_5", duration)
        toast.show()
    }

    button_7.setOnClickListener{
        Log.i(TAG,"Click no botão 7")
        onClickSymbol("7")
        val toast = Toast.makeText(this, "$text button_4", duration)
        toast.show()
    }

    button_6.setOnClickListener{
        Log.i(TAG,"Click no botão 6")
        onClickSymbol("6")
        val toast = Toast.makeText(this, "$text button_6", duration)
        toast.show()
    }

    button_5.setOnClickListener{
        Log.i(TAG,"Click no botão 5")
        onClickSymbol("5")
        val toast = Toast.makeText(this, "$text button_5", duration)
        toast.show()
    }

    button_4.setOnClickListener{
        Log.i(TAG,"Click no botão 4")
        onClickSymbol("4")
        val toast = Toast.makeText(this, "$text button_4", duration)
        toast.show()
    }

    button_3.setOnClickListener{
        Log.i(TAG,"Click no botão 3")
        onClickSymbol("3")
        val toast = Toast.makeText(this, "$text button_3", duration)
        toast.show()
    }

    button_2.setOnClickListener{
        Log.i(TAG,"Click no botão 2")
        onClickSymbol("2")
        val toast = Toast.makeText(this, "$text button_2", duration)
        toast.show()
    }

    button_1.setOnClickListener{
        Log.i(TAG,"Click no botão 1")
        onClickSymbol("1")
        val toast = Toast.makeText(this, "$text button_1", duration)
        toast.show()
    }

    button_0.setOnClickListener{
        Log.i(TAG,"Click no botão 0")
        onClickSymbol("0")
        val toast = Toast.makeText(this, "$text button_0", duration)
        toast.show()
    }

    button_dot.setOnClickListener{
        Log.i(TAG,"Click no botão .")
        onClickSymbol(".")
        val toast = Toast.makeText(this, "$text button_dot", duration)
        toast.show()
    }

    button_clear.setOnClickListener{

    }

    button_backspace.setOnClickListener{

    }

    button_equals.setOnClickListener { onClickEquals() }

    button_last.setOnClickListener {

    }

    if(orientation == Configuration.ORIENTATION_PORTRAIT){
        button_history.setOnClickListener {
            onClickHistory()
        }
    }*/
}

    private fun setupDrawerMenu(){
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close)
        nav_drawer.setNavigationItemSelectedListener(this)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START)
        if(supportFragmentManager.backStackEntryCount == 1) finish()
        super.onBackPressed()
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        text_visor.text = savedInstanceState.getString(VISOR_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        super.onSaveInstanceState(outState, outPersistentState)
    }

    @OnClick(R.id.button_history)
    fun onClickHistory(view: View){
        NavigationManager.goToHistoryFragment(supportFragmentManager)
        view.id.toString()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_calculator -> NavigationManager.goToCalculatorFragment(supportFragmentManager)
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


}
