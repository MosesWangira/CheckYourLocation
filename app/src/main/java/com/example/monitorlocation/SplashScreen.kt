package com.example.monitorlocation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.monitorlocation.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    /**
     * Declare splash image and text
     * */

    lateinit var splashImage : ImageView
    lateinit var splashText : TextView

    private lateinit var dataBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        /**
         * refer to views directly without using find view by Id using level one of data binding
         * */

        splashImage = dataBinding.geofenceImage
        splashText = dataBinding.textDefinition


        /**
         * Animate text and image on launch
         * */
        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)

        splashImage.startAnimation(animation)
        splashText.startAnimation(animation)

        /**
         * Navigate to Home Activity automatically after animation
         * */
        val toHomeActivity = Intent(this, MainActivity::class.java)

        /**
         * running on thread
         * */

        val timer = object : Thread() {
            override fun run() {
                try {
                    sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(toHomeActivity)
                    finish()
                }
            }
        }
        timer.start()
    }
}
