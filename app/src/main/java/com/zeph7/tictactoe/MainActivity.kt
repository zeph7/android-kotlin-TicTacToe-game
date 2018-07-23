package com.zeph7.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_main)

        val animClockwise = AnimationUtils.loadAnimation(applicationContext, R.anim.clockwise)
        val animMove = AnimationUtils.loadAnimation(applicationContext, R.anim.move)
        val animFade = AnimationUtils.loadAnimation(applicationContext, R.anim.fade)
        val animSlide = AnimationUtils.loadAnimation(applicationContext, R.anim.slide)
        val animZoom = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom)
        val animZoom2 = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom2)
        val animBlink = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
        imgTicTacToe.startAnimation(animBlink)
        zephGames.startAnimation(animClockwise)

        btnSingle.setOnClickListener{
            btnSingle.startAnimation(animZoom2)
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }

        btnMulti.setOnClickListener{
            btnMulti.startAnimation(animZoom2)
            startActivity(Intent(this@MainActivity, ThirdActivity::class.java))
        }

        imgTicTacToe.setOnClickListener{
            imgTicTacToe.startAnimation(animBlink)
        }

        zephGames.setOnClickListener{
            zephGames.startAnimation(animClockwise)
        }

        // back ImageView
        imageViewBack.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }

        // quit ImageView
        imageViewQuit.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }

    }

    // for handling back button of the Android Device
    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }

}
