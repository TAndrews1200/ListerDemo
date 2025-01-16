package com.fetch_test.listerdemo.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.fetch_test.listerdemo.mainActivity.composables.LoadingDisplay
import com.fetch_test.listerdemo.mainActivity.composables.NameList
import com.fetch_test.listerdemo.ui.theme.BlackStandard
import com.fetch_test.listerdemo.ui.theme.ListerDemoTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel.fetchNames()

        setContent {
            ListerDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val fetching = viewModel.fetching.observeAsState()
                    NameList(viewModel, modifier =  Modifier
                        .padding(innerPadding)
                        .fillMaxSize())
                    if (fetching.value == true) {
                        LoadingDisplay(modifier = Modifier
                            .fillMaxSize()
                            .background(color = BlackStandard))
                    }
                }
            }
        }
    }
}