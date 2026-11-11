package com.example.counter_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.counter_compose.ui.theme.Counter_ComposeTheme

enum class Screen {
    Counter,
    DataDiri
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Counter_ComposeTheme {
                var currentScreen by rememberSaveable { mutableStateOf(Screen.Counter) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (currentScreen) {
                        Screen.Counter -> {
                            CounterScreen(
                                modifier = Modifier.padding(innerPadding),
                                onNextClick = { currentScreen = Screen.DataDiri }
                            )
                        }
                        Screen.DataDiri -> {
                            DataDiriScreen(
                                modifier = Modifier.padding(innerPadding),
                                onBackClick = { currentScreen = Screen.Counter } // Kembali ke layar Counter
                            )
                        }
                    }
                }
            }
        }
    }
}