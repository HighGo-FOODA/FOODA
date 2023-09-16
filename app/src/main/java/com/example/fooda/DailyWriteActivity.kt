package com.example.fooda

import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.fooda.databinding.ActivityDailyWriteBinding

class DailyWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDailyWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pickMultipleMedia =
            registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) { uris ->
                // Callback is invoked after the user selects media items or closes the
                // photo picker.
                if (uris.isNotEmpty()) {
                    Log.d("PhotoPicker", "Number of items selected: ${uris.size}")
                    Log.d( "PhotoPicker", "${uris}")
                } else {
                    Log.d("PhotoPicker", "No media selected")
                }
            }


        binding.imageAddButton.setOnClickListener{ pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))}



    }

}