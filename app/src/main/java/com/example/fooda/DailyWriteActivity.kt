package com.example.fooda

import android.os.Bundle
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


    }

}