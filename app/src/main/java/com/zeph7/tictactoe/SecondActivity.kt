package com.zeph7.tictactoe

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_third.*
import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_second)

        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.move)
        imageViewGameOn.startAnimation(anim)

        var board = arrayListOf<String>("", "", "", "", "", "", "", "", "")

        button0.setOnClickListener {
            if (board[0] == "") {
                button0.text = "X"
                board[0] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button1.setOnClickListener {
            if (board[1] == "") {
                button1.text = "X"
                board[1] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button2.setOnClickListener {
            if (board[2] == "") {
                button2.text = "X"
                board[2] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button3.setOnClickListener {
            if (board[3] == "") {
                button3.text = "X"
                board[3] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button4.setOnClickListener {
            if (board[4] == "") {
                button4.text = "X"
                board[4] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button5.setOnClickListener {
            if (board[5] == "") {
                button5.text = "X"
                board[5] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button6.setOnClickListener {
            if (board[6] == "") {
                button6.text = "X"
                board[6] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button7.setOnClickListener {
            if (board[7] == "") {
                button7.text = "X"
                board[7] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        button8.setOnClickListener {
            if (board[8] == "") {
                button8.text = "X"
                board[8] = "X"
                if(!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
            resultOut(board)
        }

        buttonReset.setOnClickListener{
            startActivity(Intent(this@SecondActivity, SecondActivity::class.java))
        }

        // back ImageView
        imageViewBack.setOnClickListener{
            startActivity(Intent(this@SecondActivity, MainActivity::class.java))
        }

        // quit ImageView
        imageViewQuit.setOnClickListener {
            finish()
            moveTaskToBack(true)   //to quit app
        }

    }

    private fun getComputerMove(board: ArrayList<String>): Int {

        //check if computer can win in this move
        for (i in 0..board.count()-1){
            var copy: ArrayList<String> = getBoardCopy(board)
            if(copy[i] == "") copy[i] = "O"
            if(result(copy, "O")) return i
        }

        //check if player could win in the next move
        for (i in 0..board.count()-1){
            var copy2 = getBoardCopy(board)
            if(copy2[i] == "") copy2[i] = "X"
            if(result(copy2, "X")) return i
        }

        //try to take corners if its free
        var move = choseRandomMove(board, arrayListOf<Int>(0, 2, 6, 8))
        if(move != -1)
            return move

        //try to take center if its free
        if(board[4] == "") return 4

        //move on one of the sides
        return choseRandomMove(board, arrayListOf<Int>(1, 3, 5, 7))
    }


    private fun choseRandomMove(board: ArrayList<String>, list: ArrayList<Int>): Int {
        var possibleMoves = arrayListOf<Int>()
        for (i in list){
            if(board[i] == "") possibleMoves.add(i)
        }
        if(possibleMoves.isEmpty()) return -1
        else {
            var index = Random().nextInt(possibleMoves.count())
            return possibleMoves[index]
        }
    }

    private fun getBoardCopy(board: ArrayList<String>): ArrayList<String> {
        var bd = arrayListOf<String>("", "", "", "", "", "", "", "", "")
        for (i in 0..board.count()-1) {
            bd[i] = board[i]
        }
        return bd
    }

    private fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board)
            if(i != "X" && i != "O") return false
        return true
    }


    private fun resultOut(board: ArrayList<String>){
        if(result(board, "X")){
            startActivity(Intent(this@SecondActivity, WonActivity::class.java).putExtra("player", "YOU"))
        }else if(result(board, "O")){
            startActivity(Intent(this@SecondActivity, WonActivity::class.java).putExtra("player", "COMPUTER"))
        }
        if(isBoardFull(board)){
            startActivity(Intent(this@SecondActivity, WonActivity::class.java).putExtra("player", "Tie"))
        }
    }


    private fun result(bd: ArrayList<String>, s: String): Boolean =
            if(bd[0] == s && bd[1] == s && bd[2] == s) true
            else if(bd[3] == s && bd[4] == s && bd[5] == s) true
            else if(bd[6] == s && bd[7] == s && bd[8] == s) true
            else if(bd[0] == s && bd[3] == s && bd[6] == s) true
            else if(bd[1] == s && bd[4] == s && bd[7] == s) true
            else if(bd[2] == s && bd[5] == s && bd[8] == s) true
            else if(bd[0] == s && bd[4] == s && bd[8] == s) true
            else if(bd[2] == s && bd[4] == s && bd[6] == s) true
            else false


    private fun displayComputerButton(position: Int){
        if(position == 0) button0.text = "O"
        else if(position == 1) button1.text = "O"
        else if(position == 2) button2.text = "O"
        else if(position == 3) button3.text = "O"
        else if(position == 4) button4.text = "O"
        else if(position == 5) button5.text = "O"
        else if(position == 6) button6.text = "O"
        else if(position == 7) button7.text = "O"
        else if(position == 8) button8.text = "O"
    }


    // for handling back buttton of the Android Device
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@SecondActivity, MainActivity::class.java))
    }

}
