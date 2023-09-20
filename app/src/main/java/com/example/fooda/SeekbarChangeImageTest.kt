package com.example.fooda

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SeekbarChangeImageTest : AppCompatActivity() {

    //TODO seekbar thumb 순서대로 돌아가도록

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overallreview_write)

        val customSeekBar: SeekBar = findViewById(R.id.customSeekBar2)
        customSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val maxProgress = seekBar?.max ?: 100
                val thumbDrawable = when {
                    progress <= maxProgress / 3 -> R.drawable.seekbar_thumb_happy1
                    progress <= (maxProgress * 2) / 3 -> R.drawable.seekbar_thumb_happy2
                    else -> R.drawable.illust_happy
                }
                seekBar?.thumb = ContextCompat.getDrawable(this@SeekbarChangeImageTest, thumbDrawable)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}