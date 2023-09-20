package com.example.fooda

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.fooda.databinding.ActivityDailyWriteBinding

class DailyWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyWriteBinding
    private val selectedImageUris = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDailyWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FIXME 은근 로딩이 느리다
        //FIXME 비디오 업로드 안되게 막기
        val pickMultipleMedia =
            registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) { uris ->
                if (uris.isNotEmpty()) {
                    Log.d("PhotoPicker", "${uris}")
                    for (uri in uris) {
                        selectedImageUris.add(uri.toString())
                    }
                    displaySelectedImages()
                }
            }


        binding.imageAddButton.setOnClickListener {
            pickMultipleMedia.launch(
                PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.ImageAndVideo
                )
            )
        }


    }

    //FIXME 현재는 선택 할 때만 5개 제한 -> 전체 업로드를 5개로 제한 할 것인가에 대해서
    //TODO 전체 업로드 개수 5개 체크
    //TODO 추가 업로드해도 앞에 기존 업로드 픽한 사진은 삭제 하지 않도록
    //TODO 5개 넘어갔을 때의 경고 문구 + list의 앞에서부터 5개로 컷하고 뒤에는 무시하는 로직으로
    private fun displaySelectedImages() {
        val linearLayout = binding.imageLinearLayout
        linearLayout.removeAllViews()

        for (imageUri in selectedImageUris) {
            val imageView = ImageView(this)

            //이 부분 필요한가에 대해서
            val imageLayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            imageView.layoutParams = imageLayoutParams
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP

            val cardView = CardView(this)

            val cardLayoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.image_width), // CardView의 너비
                resources.getDimensionPixelSize(R.dimen.image_height) // CardView의 높이
            )

            //카드뷰 사이의 간격
            //FIXME 카드뷰 사이 간격 수정
            cardLayoutParams.setMargins(
                0,
                0,
                20,
                0
            )
            cardView.layoutParams = cardLayoutParams
            cardView.radius = resources.getDimension(R.dimen.corner_radius)

            cardView.addView(imageView)

            imageView.setImageURI(Uri.parse(imageUri))
            linearLayout.addView(cardView)

        }
    }

}
