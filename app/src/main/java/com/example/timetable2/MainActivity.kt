package com.example.timetable2

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until 24) {
            createTextForTimeRange(i)
        }
        createHeightTimeRange()

        createHeightTimeline()
    }

    private fun createHeightTimeline() {

    }

    private fun createHeightTimeRange() {
        var heightInTimeRange = relativetimeRange.layoutParams as RelativeLayout.LayoutParams

        heightInTimeRange.height = ((dpToPx(100) * 24).toInt())
        heightInTimeRange.width = dpToPx(50).toInt()
    }

    private fun createTextForTimeRange(hour: Int) {
        var text = TextView(this)

        text.translationY = (dpToPx(100) * hour)
        text.setBackgroundColor(Color.GREEN)

        text.setText("hgjhghggjggkjgj")
//        text.setText("${getTextHaiCot(hour)}:00")

        relativetimeRange.addView(text)

        var layoutParam = text.layoutParams as RelativeLayout.LayoutParams

        layoutParam.width = 500
        layoutParam.height = 50

        text.layoutParams = layoutParam
    }

    private fun getTextHaiCot(hour: Int): String {
        if (hour < 10) {
            return "0${hour}"
        }
        return hour.toString()
    }


    fun pxToDp(px: Int): Float {
        return (px / Resources.getSystem().getDisplayMetrics().density)
    }

    fun dpToPx(dp: Int): Float {
        return (dp * Resources.getSystem().getDisplayMetrics().density)
    }
}
