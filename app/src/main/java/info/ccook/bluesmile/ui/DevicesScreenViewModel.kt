package info.ccook.bluesmile.ui

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import info.ccook.bluesmile.data.bluetooth.models.BluetoothDevice
import info.ccook.bluesmile.domain.bluetooth.GetPairedDevicesUseCase
import javax.inject.Inject

@HiltViewModel
class DevicesScreenViewModel @Inject constructor(
    private val getPairedDevicesUseCase: GetPairedDevicesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DevicesScreenState())
    val state: State<DevicesScreenState> = _state

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    fun getPairedDevices() {
        val pairedDevices = getPairedDevicesUseCase()
        _state.value = _state.value.copy(pairedDevices = pairedDevices)
    }
}

data class DevicesScreenState(
    val pairedDevices: List<BluetoothDevice> = listOf()
)
