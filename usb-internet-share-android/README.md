# USB Internet Share Android App

This is a minimal Android app to detect USB network interface and display connection status. It is intended to be used with PC-side setup to share internet connection to the phone via USB.

## PC-side Setup

### Linux

1. Enable USB Ethernet gadget (RNDIS) on your PC.
2. Share your PC internet connection to the USB network interface.
3. Connect your phone via USB and enable USB tethering on the phone if needed.

Example commands to enable USB gadget on Linux:

```bash
sudo modprobe libcomposite
cd /sys/kernel/config/usb_gadget/
sudo mkdir -p g1
cd g1
sudo echo 0x1d6b > idVendor
sudo echo 0x0104 > idProduct
# Configure strings, functions, and configs here
# Enable RNDIS function
# Bind to UDC
```

### Windows

1. Enable Internet Connection Sharing (ICS) on your PC.
2. Connect your phone via USB.
3. The phone should detect the USB network interface.

## Build and Run

1. Open the project in Android Studio.
2. Build and run the app on your Android device.
3. The app will display USB device connection status and USB network status.

## Notes

- This app only detects USB network interface and does not manage PC-side sharing.
- PC-side setup is required for internet sharing to work.
