package info.ccook.bluesmile.data.bluetooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import androidx.annotation.RequiresPermission
import info.ccook.bluesmile.data.bluetooth.models.BluetoothDevice

interface BluetoothRepository {

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    fun getPairedDevices(): List<BluetoothDevice>
}

class BluetoothRepositoryImpl(
    private val bluetoothAdapter: BluetoothAdapter,
    private val mapper: Mapper = MapperImpl()
) : BluetoothRepository {

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    override fun getPairedDevices(): List<BluetoothDevice> {
        return mapper.androidBluetoothDevicesToBluetoothDevices(bluetoothAdapter.bondedDevices)
    }
}
