package com.example.fooda

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

//TODO 총평view 잘린 이미지로 교체
class OverallreviewViewActivity : AppCompatActivity() {
    private lateinit var imageButton: ImageButton
    private val imageIds = arrayOf(
        R.drawable.illust_angry,
        R.drawable.illust_curious,
        R.drawable.illust_happy,
        R.drawable.illust_sad,
        R.drawable.illust_soso
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overallreview_end)

        imageButton = findViewById(R.id.overallreviewViewGoToDailyTimelineButton)
        val randomImage: ImageView = findViewById(R.id.randomImage)

        // setImageB 완료 버튼 바꾸기
        imageButton.setOnClickListener {
            setImageB()
        }

        val randomIndex = Random.nextInt(imageIds.size)
        val randomImageId = imageIds[randomIndex]

        //random이미지
        randomImage.setImageResource(randomImageId)
    }

    private fun setImageB() {
        // 완료 버튼 바꾸기
        imageButton.setImageResource(R.drawable.button_end_pressed_text)
    }
}

