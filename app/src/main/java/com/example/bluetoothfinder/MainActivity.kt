package com.example.bluetoothfinder

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothDevice.ACTION_FOUND
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
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
    private val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var action: String? = intent?.action
            Log.i("Action", action!!)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        statusTextView = findViewById(R.id.statusTextView)
        searchButton = findViewById(R.id.searchButton)

        var intentFilter: IntentFilter = IntentFilter()
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        intentFilter.addAction(ACTION_FOUND)
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        registerReceiver(broadcastReceiver, intentFilter)

        bluetoothAdapter.startDiscovery()
    }

    fun onSearchClicked(view: View) {
        Log.i("Search Button Clicked", "Searching...")
        statusTextView?.text = getString(R.string.searching)
        searchButton?.isEnabled = false
        searchButton?.isClickable = false
        searchButton?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.greyish))
    }
}