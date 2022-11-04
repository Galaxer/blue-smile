package info.ccook.bluesmile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun DevicesScreen(viewModel: DevicesScreenViewModel) {

    val state by viewModel.state

    Column(Modifier.fillMaxSize()) {
        Text(text = "Devices")
    }
}
