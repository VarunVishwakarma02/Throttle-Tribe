package com.example.ridingwithstranger

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.ridingwithstranger.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.*
import androidx.lifecycle.lifecycleScope
import android.content.Intent
import kotlin.jvm.java

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeViews()
        startAnimations()
        navigateAfterDelay()
    }

    private fun initializeViews() {
        with(binding) {
            listOf(appLogo, appName, tagline, loadingProgress, loadingText)
                .forEach { it.alpha = 0f }
        }
    }

    private fun startAnimations() {
        with(binding) {
            appLogo.fadeInWithScale(duration = 800, startDelay = 300)
            appName.fadeInWithSlide(duration = 600, startDelay = 800)
            tagline.fadeInWithSlide(duration = 600, startDelay = 1200)
            loadingProgress.fadeIn(duration = 400, startDelay = 1600)
            loadingText.fadeIn(duration = 400, startDelay = 1800)
        }
        startRoadLineAnimations()
    }

    private fun startRoadLineAnimations() {
        handler = Handler(Looper.getMainLooper())
        handler?.postDelayed({
            with(binding) {
                val roadViews = listOf(roadLine1, roadLine2, roadLine3)
                roadViews.forEachIndexed { index, view ->
                    handler?.postDelayed({
                        view.startMovingAnimation()
                    }, index * 300L)
                }
            }
        }, 2000)
    }

    private fun navigateAfterDelay() {
        lifecycleScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashScreen, LogInPage::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacksAndMessages(null)
    }
}

fun View.fadeIn(duration: Long, startDelay: Long = 0): ViewPropertyAnimator {
    return animate()
        .alpha(1f)
        .setDuration(duration)
        .setStartDelay(startDelay)
        .also { it.start() }
}

fun View.fadeInWithScale(duration: Long, startDelay: Long = 0): ViewPropertyAnimator {
    return animate()
        .alpha(1f)
        .scaleX(1f)
        .scaleY(1f)
        .setDuration(duration)
        .setStartDelay(startDelay)
        .also { it.start() }
}

fun View.fadeInWithSlide(duration: Long, startDelay: Long = 0): ViewPropertyAnimator {
    return animate()
        .alpha(1f)
        .translationY(0f)
        .setDuration(duration)
        .setStartDelay(startDelay)
        .also { it.start() }
}

fun View.startMovingAnimation() {
    val moveAnimation = TranslateAnimation(
        Animation.RELATIVE_TO_PARENT, 1.0f,
        Animation.RELATIVE_TO_PARENT, -1.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f
    ).apply {
        duration = 2000
        repeatCount = Animation.INFINITE
    }
    startAnimation(moveAnimation)
}