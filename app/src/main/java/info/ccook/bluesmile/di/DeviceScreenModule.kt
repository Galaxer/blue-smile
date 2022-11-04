package info.ccook.bluesmile.di

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import info.ccook.bluesmile.data.bluetooth.BluetoothRepository
import info.ccook.bluesmile.data.bluetooth.BluetoothRepositoryImpl
import info.ccook.bluesmile.data.bluetooth.Mapper
import info.ccook.bluesmile.data.bluetooth.MapperImpl
import info.ccook.bluesmile.domain.bluetooth.GetPairedDevicesUseCase
import info.ccook.bluesmile.domain.bluetooth.GetPairedDevicesUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
object DeviceScreenModule {

    @Provides
    fun provideGetPairedDevicesUseCase(
        bluetoothRepository: BluetoothRepository
    ): GetPairedDevicesUseCase {
        return GetPairedDevicesUseCaseImpl(bluetoothRepository)
    }

    @Provides
    fun provideBluetoothRepository(
        bluetoothAdapter: BluetoothAdapter,
        mapper: Mapper
    ): BluetoothRepository {
        return BluetoothRepositoryImpl(bluetoothAdapter, mapper)
    }

    @Provides
    fun provideMapper(): Mapper {
        return MapperImpl()
    }

    @Provides
    fun provideBlueToothManager(@ApplicationContext context: Context): BluetoothManager {
        return context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    }

    @Provides
    fun provideBlueToothAdapter(bluetoothManager: BluetoothManager): BluetoothAdapter {
        return bluetoothManager.adapter
    }
}
