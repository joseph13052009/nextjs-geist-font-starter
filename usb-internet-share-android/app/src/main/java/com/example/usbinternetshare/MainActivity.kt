package com.example.usbinternetshare

import android.app.Activity
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var statusTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusTextView = TextView(this)
        setContentView(statusTextView)

        checkUsbNetwork()
    }

    private fun checkUsbNetwork() {
        val usbManager = getSystemService(USB_SERVICE) as UsbManager
        val deviceList: HashMap<String, UsbDevice> = usbManager.deviceList

        if (deviceList.isNotEmpty()) {
            statusTextView.text = "USB device(s) connected:\n"
            for (device in deviceList.values) {
                statusTextView.append("Device: ${device.deviceName}\n")
            }
        } else {
            statusTextView.text = "No USB devices connected."
        }

        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)

        if (capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_USB)) {
            statusTextView.append("\nUSB network is active.")
        } else {
            statusTextView.append("\nUSB network is not active.")
        }
    }
}
