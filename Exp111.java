//Mainactivity.java
package com.example.colorpicker

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.colorpicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var hsv = floatArrayOf(0f, 1f, 1f)
    private var alpha = 255

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colorWheel = binding.colorWheel
        val preview = binding.previewColor

        colorWheel.setOnColorChangeListener { hue, saturation ->
            hsv[0] = hue
            hsv[1] = saturation
            updateColor()
        }

        binding.alphaSeekBar.setOnSeekBarChangeListener(seekListener { value ->
            alpha = value
            updateColor()
        })

        binding.valueSeekBar.setOnSeekBarChangeListener(seekListener { value ->
            hsv[2] = value / 100f
            updateColor()
        })
    }

    private fun updateColor() {
        val color = Color.HSVToColor(alpha, hsv)
        binding.previewColor.setBackgroundColor(color)
    }

    private fun seekListener(onProgressChanged: (progress: Int) -> Unit) =
        object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                onProgressChanged(progress)
            }

            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        }
}

A//ctivity.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/rootLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="20dp">

    <com.example.colorpicker.ColorWheelView
        android:id="@+id/colorWheel"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="40dp" />

    <SeekBar
        android:id="@+id/alphaSeekBar"
        android:layout_below="@id/colorWheel"
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:max="255"/>

    <SeekBar
        android:id="@+id/valueSeekBar"
        android:layout_below="@id/alphaSeekBar"
        android:layout_marginTop="10dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:max="100"/>

    <View
        android:id="@+id/previewColor"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:layout_below="@id/valueSeekBar"
        android:layout_marginTop="20dp"
        android:background="#FFFFFF"/>

</RelativeLayout>