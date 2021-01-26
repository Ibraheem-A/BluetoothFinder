package com.example.bluetoothfinder

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    var listView: ListView? = null
    var statusTextView: TextView? = null
    var searchButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        statusTextView = findViewById(R.id.statusTextView)
        searchButton = findViewById(R.id.searchButton)
    }

    fun onSearchClicked(view: View) {
        Log.i("Search Button Clicked", "Searching...")
        statusTextView?.text = getString(R.string.searching)
        searchButton?.isEnabled = false
        searchButton?.isClickable = false
        searchButton?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.greyish))
    }
}