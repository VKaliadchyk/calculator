package com.vk.app.calculator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.vk.app.calculator.ui.feature.calculator.simple.SimpleCalculatorScreen
import com.vk.app.calculator.ui.feature.calculator.simple.SimpleCalculatorScreenViewModel
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState
import com.vk.app.calculator.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                val viewModel: SimpleCalculatorScreenViewModel = hiltViewModel()
                val uiState: SimpleCalculatorScreenUiState by viewModel.uiState.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SimpleCalculatorScreen(
                        modifier = Modifier.padding(innerPadding),
                        uiState = uiState,
                        uiEvent = { uiEvent -> viewModel.handleUiEvent(uiEvent) }
                    )
                }
            }
        }
    }
}
