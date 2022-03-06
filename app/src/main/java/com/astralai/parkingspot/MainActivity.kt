package com.astralai.parkingspot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.astralai.parkingspot.presentation.MapScreen
import com.astralai.parkingspot.presentation.WindowSizeClass
import com.astralai.parkingspot.presentation.rememberWindowSizeClass
import com.astralai.parkingspot.ui.theme.ParkingSpotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = rememberWindowSizeClass()
            when (windowSize.widthWindowSizeClass) {
                is WindowSizeClass.WindowType.COMPACT -> {
                    CompactActivityUi()
                    /*TODO(reason = "Ui for COMPACT window")*/
                }
                is WindowSizeClass.WindowType.MEDIUM -> {
                    /*TODO(reason = "Ui for Medium window")*/
                }
                else -> {
                    /*TODO(reason = "Ui for EXPANDED window")*/
                    CompactActivityUi()
                }
            }
        }
    }
}

@Composable
fun CompactActivityUi() {
    ParkingSpotTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MapScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompactActivityUi()
}