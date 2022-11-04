package info.ccook.bluesmile.domain.bluetooth

import android.Manifest
import androidx.annotation.RequiresPermission
import info.ccook.bluesmile.data.bluetooth.BluetoothRepository
import info.ccook.bluesmile.data.bluetooth.models.BluetoothDevice

interface GetPairedDevicesUseCase {

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    operator fun invoke(): List<BluetoothDevice>
}

class GetPairedDevicesUseCaseImpl(
    private val bluetoothRepository: BluetoothRepository
) : GetPairedDevicesUseCase {

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    override fun invoke(): List<BluetoothDevice> {
        return bluetoothRepository.getPairedDevices()
    }
}
