package com.example.neoman.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

//a lot of this code is bad form, copy and paste rather than for loops etc. just some quick coding

class MainActivity : AppCompatActivity() {
    private var move=0
    private var spots= arrayOf('e','e','e','e','e','e','e','e','e')
    private var over:Boolean=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun checkWin():Int{
        if(move<5){
            return -1
        }
        var winner= ""

        if(spots[0]=='X'&&spots[1]=='X'&&spots[2]=='X') {
            winner="X's"
        }
        else if(spots[0]=='X'&&spots[3]=='X'&&spots[6]=='X') {
            winner="X's"
        }
        else if(spots[0]=='X'&&spots[4]=='X'&&spots[8]=='X') {
            winner="X's"
        }
        else if(spots[3]=='X'&&spots[4]=='X'&&spots[5]=='X') {
            winner="X's"
        }
        else if(spots[6]=='X'&&spots[4]=='X'&&spots[2]=='X') {
            winner="X's"
        }
        else if(spots[6]=='X'&&spots[7]=='X'&&spots[8]=='X') {
            winner="X's"
        }
        else if(spots[1]=='X'&&spots[4]=='X'&&spots[7]=='X') {
            winner="X's"
        }
        else if(spots[2]=='X'&&spots[5]=='X'&&spots[8]=='X') {
            winner="X's"
        }
        else if(spots[0]=='O'&&spots[1]=='O'&&spots[2]=='O') {
            winner="O's"
        }
        else if(spots[0]=='O'&&spots[3]=='O'&&spots[6]=='O') {
            winner="O's"
        }
        else if(spots[0]=='O'&&spots[4]=='O'&&spots[8]=='O') {
            winner="O's"
        }
        else if(spots[3]=='O'&&spots[4]=='O'&&spots[5]=='O') {
            winner="O's"
        }
        else if(spots[6]=='O'&&spots[4]=='O'&&spots[2]=='O') {
            winner="O's"
        }
        else if(spots[6]=='O'&&spots[7]=='O'&&spots[8]=='O') {
            winner="O's"
        }
        else if(spots[1]=='O'&&spots[4]=='O'&&spots[7]=='O') {
            winner="O's"
        }
        else if(spots[2]=='O'&&spots[5]=='O'&&spots[8]=='O') {
            winner="O's"
        }

        if(winner!=""){
            Toast.makeText(this,winner+" won in "+move+" moves", Toast.LENGTH_LONG).show()
            return 1
        }
        else if(move==9){
            Toast.makeText(this,"It is a draw", Toast.LENGTH_LONG).show()
            return 0
        }
        return -1
    }

    protected fun makeMove(){
        var chose = Random().nextInt(9)
        while (spots[chose]!='e') {
            chose = Random().nextInt(9)
        }
        val but: Button?
        when (chose) {
            0 -> but = a1
            1 -> but = a2
            2 -> but = a3
            3 -> but = b1
            4 -> but = b2
            5 -> but = b3
            6 -> but = c1
            7 -> but = c2
            8 -> but = c3
            else -> but = a1//this should never happen
        }
        but.text = "O"
        but.setBackgroundColor(Color.GREEN)
        but.isEnabled = false
        spots[chose]='O'
        move++
        if (checkWin() != -1) {
            over = true
        }
    }

    protected fun move(view: View){
        if(!over) {
            val but = view as Button
            var cell=-1
            when (but) {
                a1 -> cell = 0
                a2 -> cell = 1
                a3 -> cell = 2
                b1 -> cell = 3
                b2 -> cell = 4
                b3 -> cell = 5
                c1 -> cell = 6
                c2 -> cell = 7
                c3 -> cell = 8
            }
            but.text = "X"
            but.setBackgroundColor(Color.YELLOW)
            but.isEnabled = false
            spots[cell]='X'
            move++
            if (checkWin() != -1) {
                //only try to make a move if no one has won and still spots left for AI
                over = true
            } else {
                makeMove()
            }
        }
    }

    protected fun newGame(view: View){
        spots= arrayOf('e','e','e','e','e','e','e','e','e')
        move=0
        over=false

        a1.text= ""
        a1.setBackgroundColor(Color.GRAY)
        a1.isEnabled=true
        a2.text= ""
        a2.setBackgroundColor(Color.GRAY)
        a2.isEnabled=true
        a3.text= ""
        a3.setBackgroundColor(Color.GRAY)
        a3.isEnabled=true
        b1.text= ""
        b1.setBackgroundColor(Color.GRAY)
        b1.isEnabled=true
        b2.text= ""
        b2.setBackgroundColor(Color.GRAY)
        b2.isEnabled=true
        b3.text= ""
        b3.setBackgroundColor(Color.GRAY)
        b3.isEnabled=true
        c1.text= ""
        c1.setBackgroundColor(Color.GRAY)
        c1.isEnabled=true
        c2.text= ""
        c2.setBackgroundColor(Color.GRAY)
        c2.isEnabled=true
        c3.text= ""
        c3.setBackgroundColor(Color.GRAY)
        c3.isEnabled=true
    }
}
