package info.ccook.bluesmile.data.bluetooth

import android.Manifest
import androidx.annotation.RequiresPermission
import info.ccook.bluesmile.data.bluetooth.models.BluetoothDevice

interface Mapper {

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    fun androidBluetoothDeviceToBluetoothDevice(
        androidBluetoothDevice: android.bluetooth.BluetoothDevice
    ): BluetoothDevice

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    fun androidBluetoothDevicesToBluetoothDevices(
        androidBluetoothDevices: Set<android.bluetooth.BluetoothDevice>
    ): List<BluetoothDevice>
}

class MapperImpl : Mapper {

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    override fun androidBluetoothDeviceToBluetoothDevice(
        androidBluetoothDevice: android.bluetooth.BluetoothDevice
    ): BluetoothDevice {
        return BluetoothDevice(
            name = androidBluetoothDevice.name
        )
    }

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    override fun androidBluetoothDevicesToBluetoothDevices(
        androidBluetoothDevices: Set<android.bluetooth.BluetoothDevice>
    ): List<BluetoothDevice> {
        return androidBluetoothDevices.map { androidBluetoothDevice ->
            androidBluetoothDeviceToBluetoothDevice(androidBluetoothDevice)
        }
    }
}
