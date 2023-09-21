package com.example.fooda

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DatePickerBottomSheet(context: Context) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.activity_datepicker, container, false)

        // DatePicker에서 헤더 뷰 숨기기
        val datePicker = view.findViewById<DatePicker>(R.id.datePicker)
        val datePickerHeaderId = resources.getIdentifier("date_picker_header", "id", "android")
        val datePickerHeader = datePicker.findViewById<View>(datePickerHeaderId)
        datePickerHeader?.visibility = View.GONE

        return view
    }

    //어떤 버튼을 눌러야 datepicker가 올라오는지
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.findViewById<Button>(R.id.datepick)?.setOnClickListener {
            dismiss()
        }
    }
}
