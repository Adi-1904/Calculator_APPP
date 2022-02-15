package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.mariuszgromada.math.mxparser.*
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var previous:TextView
    lateinit var result: TextView
    private var update=true
    private var clear=false
    private var canaddoperation=false
    private var canadddot=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        previous=findViewById(R.id.previous)
        result=findViewById(R.id.current)





    }
    private fun updatetext(s: String) {
          if(update==true)
           result.append(s)
    }
    fun zeroBTNpush(view: View)
    {updatetext("0")
    canaddoperation=true
    canadddot=true}
    fun oneBTNpush(view: View)
    {updatetext("1")
        canaddoperation=true
    canadddot=true}
    fun twoBTNpush(view: View)
    {updatetext("2")
        canaddoperation=true
        canadddot=true}
    fun threeBTNpush(view: View)
    {updatetext("3")
        canaddoperation=true
        canadddot=true}
    fun fourBTNpush(view: View)
    {updatetext("4")
        canaddoperation=true
        canadddot=true}
    fun fiveBTNpush(view: View)
    {updatetext("5")
        canaddoperation=true
        canadddot=true}
    fun sixBTNpush(view: View)
    {updatetext("6")
        canaddoperation=true
        canadddot=true}
    fun sevenBTNpush(view: View)
    {updatetext("7")
        canaddoperation=true
        canadddot=true}
    fun eightBTNpush(view: View)
    {updatetext("8")
        canaddoperation=true
        canadddot=true}
    fun nineBTNpush(view: View)
    {updatetext("9")
        canaddoperation=true
        canadddot=true}
    fun dotBTNpush(view: View)
    {if(canadddot==true)
    {updatetext(".")
      canadddot=false}}
    fun subBTNpush(view: View)
    {
        updatetext("-")
        canaddoperation=false
    }
    fun sumBTNpush(view: View) {
        if(canaddoperation==true) {
            updatetext("+")
            canaddoperation=false
        }}
    fun multiplyBTNpush(view: View) {
        if(canaddoperation==true) {
        updatetext("*")
        canaddoperation=false
    }}
    fun divideBTNpush(view: View) {
        if(canaddoperation==true) {
            updatetext("/")
            canaddoperation=false
        }
    }
    fun bracketoffBTNpush(view: View) {updatetext(")")}
    fun bracketonBTNpush(view: View) {updatetext("(")}
    fun allclear(view: View) {
        result.text=""
        previous.text=""
        update=true
    }
    fun backspace(view: View) {
        if (clear==true)
        {
            result.text=""
            previous.text=""
            clear=false
            update=true
        }
        else {
            val length = result.length()
            if (length > 0)
                result.text = result.text.subSequence(0, length - 1)
            else if (length == 0) {
                previous.text = ""
                update = true
            }
        }
    }
    fun equalBTNpush(view: View) {
        try {
            var expression: String = result.text.toString()
            previous.text=expression
            val final = Expression(expression).calculate()
            if(final.isNaN())
            {
                result.text="Error"
                update=false
                clear=true


            }
            else
            {
                result.text=DecimalFormat("0.######").format(final).toString()
            }
        }
        catch (e:Exception)
        {
            result.text="error"
            update=false
            clear=true

        }
    }

    fun xyButtonPush(view: View) {updatetext("^(")}
    fun sinButtonPush(view: View) {updatetext("sin(")}
    fun cosButtonPush(view: View) {updatetext("cos(")}
    fun tanButtonPush(view: View) {updatetext("tan(")}
    fun sininverseButtonPush(view: View) {updatetext("asin(")}
    fun cosinverseButtonPush(view: View) {updatetext("acos(")}
    fun taninverseButtonPush(view: View) {updatetext("atan(")}
    fun logButtonPush(view: View) {updatetext("log10(")}
    fun lnButtonPush(view: View) {updatetext("ln(")}
    fun sqrtButtonPush(view: View) {updatetext("sqrt(")}
    fun expoButtonPush(view: View) {updatetext("e")}
    fun piButtonPush(view: View) {updatetext("pi")}
    fun modButtonPush(view: View) {updatetext("abs(")}
    fun exponentButtonPush(view: View) {
        if(canaddoperation==true) {
            updatetext("!")
            canaddoperation=true
        }}
    fun squareButtonPush(view: View) {
        if(canaddoperation==true)
        {updatetext("^(2)")
        canaddoperation=true}}


}