package com.example.theoremapifaghor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.theoremapifaghor.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    fun onClickRes(view: View) {
        if(!isFieldEmpty()) {
            val res = getString(R.string.result_info) + calculatePifagor()
            bind.tvResult.text = res
        }
    }

    private fun isFieldEmpty():Boolean {
        bind.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Это поле не заполнено"
            if(edB.text.isNullOrEmpty()) edB.error = "Это поле не заполнено"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }
    private fun calculatePifagor(): String {
        bind.apply {
            val a = edA.text.toString().toDouble()
            val b = edB.text.toString().toDouble()
            var res =  sqrt(a.pow(2) + b.pow(2))
            if(res % 2 == 0.0) return res.toInt().toString()
            else return res.toString()
        }
    }
}